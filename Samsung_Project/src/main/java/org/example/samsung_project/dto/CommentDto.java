package org.example.samsung_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String content;
    private Long postId; // 어떤 게시글에 달린 댓글인지 식별하기 위한 ID
}