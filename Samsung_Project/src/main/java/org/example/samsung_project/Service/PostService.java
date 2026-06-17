package org.example.samsung_project.Service;

import lombok.RequiredArgsConstructor;
import org.example.samsung_project.dto.PostDto;
import org.example.samsung_project.Exception.PostNotFoundException;
import org.example.samsung_project.Exception.UserNotFoundException;
import org.example.samsung_project.Repository.PostRepository;
import org.example.samsung_project.Repository.UserRepository;
import org.example.samsung_project.domain.Post;
import org.example.samsung_project.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 현재 인증된 사용자 가져오기 내부 메서드
    private User getCurrentUser() {
        String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UserNotFoundException("인증된 사용자를 찾을 수 없습니다."));
    }

    @Transactional
    public Post createPost(PostDto postDto) {
        User currentUser = getCurrentUser();
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setUser(currentUser);
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long id, PostDto postDto) {
        Post post = getPost(id);
        User currentUser = getCurrentUser();

        if (!post.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("본인의 게시글만 수정할 수 있습니다.");
        }

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = getPost(id);
        User currentUser = getCurrentUser();

        if (!post.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("본인의 게시글만 삭제할 수 있습니다.");
        }
        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Transactional(readOnly = true)
    public Page<Post> searchPosts(String keyword, Pageable pageable) {
        return postRepository.findByTitleContaining(keyword, pageable);
    }
}