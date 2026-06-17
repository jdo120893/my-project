package org.example.samsung_project.Controller;

import lombok.RequiredArgsConstructor;
import org.example.samsung_project.dto.CommentDto;
import org.example.samsung_project.Service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 1. 댓글 등록
    @PostMapping("/new")
    public String createComment(@ModelAttribute CommentDto commentDto) {
        commentService.createComment(commentDto);

        // ⭐ 핵심: 댓글 작성 후, 해당 댓글이 달린 게시글 상세 페이지로 강제 이동합니다.
        // (CommentDto 안에 postId가 들어있다고 가정합니다)
        return "redirect:/posts/" + commentDto.getPostId();
    }

    // 2. 댓글 삭제
    @PostMapping("/{id}/delete")
    public String deleteComment(@PathVariable Long id, @RequestParam Long postId) {
        commentService.softDeleteComment(id);

        return "redirect:/posts/" + postId;
    }
}