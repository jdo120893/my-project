package org.example.samsung_project.Service;

import lombok.RequiredArgsConstructor;
import org.example.samsung_project.Exception.CommentNotFoundException;
import org.example.samsung_project.Exception.PostNotFoundException;
import org.example.samsung_project.Exception.UserNotFoundException;
import org.example.samsung_project.Repository.CommentRepository;
import org.example.samsung_project.Repository.PostRepository;
import org.example.samsung_project.Repository.UserRepository;
import org.example.samsung_project.domain.Comment;
import org.example.samsung_project.domain.Post;
import org.example.samsung_project.domain.User;
import org.example.samsung_project.dto.CommentDto;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

   private User getCurrentUser(){
       String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
       return userRepository.findByLoginId(loginId).orElseThrow(()->
               new UserNotFoundException("사용자를 찾을 수 없습니다."));

   }

    @Transactional
    public Comment createComment(CommentDto commentDto){

       Post post = postRepository.findById(commentDto.getPostId())
               .orElseThrow(()->new PostNotFoundException("게시물을 찾을 수 없습니다."));

       Comment comment = new Comment();
       comment.setContent(commentDto.getContent());
       comment.setPost(post);
       comment.setUser(getCurrentUser());
       comment.setDelYn(false);

       return commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<Comment> getCommentsByPostId(Long postId) {
        // delYn이 false인 것만 조회하도록 Repository에 메서드 생성 필요
        return commentRepository.findByPostIdAndDelYnFalseOrderByRegdateAsc(postId);
    }

    @Transactional
    public void softDeleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("댓글을 찾을 수 없습니다."));

        User currentUser = getCurrentUser();
        if (!comment.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("본인의 댓글만 삭제할 수 있습니다.");
        }

        comment.setDelYn(true);
        commentRepository.save(comment); // 변경 감지로 업데이트됨
    }
}