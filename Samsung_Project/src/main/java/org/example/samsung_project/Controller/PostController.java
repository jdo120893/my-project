package org.example.samsung_project.Controller;


import lombok.RequiredArgsConstructor;
import org.example.samsung_project.Service.CommentService;
import org.example.samsung_project.domain.Comment;
import org.example.samsung_project.domain.Post;
import org.example.samsung_project.dto.PostDto;
import org.example.samsung_project.Service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    // [추가] 글쓰기 화면으로 이동
    @GetMapping("/new")
    public String createPostForm() {
        return "post/writeform"; // templates/post/writeform.html
    }

    // 2. 게시글 등록 처리
    @PostMapping("/new")
    public String createPost(@ModelAttribute PostDto postDto) {
        postService.createPost(postDto);
        return "redirect:/posts"; // 등록 후 글 목록 페이지로 리다이렉트
    }

    // [추가] 글 수정 화면으로 이동
    @GetMapping("/{id}/edit")
    public String updatePostForm(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post/editform"; // templates/post/editform.html
    }

    // 3. 게시글 수정 처리
    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute PostDto postDto) {
        postService.updatePost(id, postDto);
        return "redirect:/posts/" + id; // 수정 후 해당 글 상세 페이지로 리다이렉트
    }

    // 4. 게시글 삭제 처리
    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts"; // 삭제 후 글 목록 페이지로 리다이렉트
    }

    // 5. 전체 게시글 목록 조회 (페이징 적용)
    @GetMapping
    public String getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "postedDate"));
        Page<Post> postPage = postService.getPosts(pageRequest);

        // 타임리프 화면에서 사용할 데이터 전달
        model.addAttribute("posts", postPage.getContent()); // 게시글 목록 데이터 (List<Post>)
        model.addAttribute("pageInfo", postPage);           // 페이징 처리를 위한 페이지 정보 전체

        return "post/list"; // templates/post/list.html
    }

    // 6. 게시글 상세 조회
    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable Long id, Model model) {

        // 💡 2. PostResponseDto 대신 실제 존재하는 'Post' 엔티티(또는 PostDto)를 사용합니다.
        // ※ 만약 postService의 메서드명이 다르면 findById 나 getPost 등으로 맞춰주세요.
        Post post = postService.getPost(id);
        model.addAttribute("post", post);

        // 💡 3. CommentResponseDto 대신 실제 존재하는 'Comment' 엔티티(또는 CommentDto)를 사용합니다.
        // 주입받은 commentService를 사용하여 댓글 목록을 가져옵니다.
        List<Comment> comments = commentService.getCommentsByPostId(id);
        model.addAttribute("comments", comments);

        return "post/detail";
    }

    // 7. 게시글 검색
    @GetMapping("/search")
    public String searchPosts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "postedDate"));
        Page<Post> searchResults = postService.searchPosts(keyword, pageRequest);

        model.addAttribute("posts", searchResults.getContent());
        model.addAttribute("pageInfo", searchResults);
        model.addAttribute("keyword", keyword); // 검색창에 검색어 유지용

        return "post/list"; // 검색 결과 화면도 일반 목록(list.html) 화면을 재사용합니다.
    }
}