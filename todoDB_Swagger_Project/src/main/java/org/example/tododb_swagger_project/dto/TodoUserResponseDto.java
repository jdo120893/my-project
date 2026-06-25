package org.example.tododb_swagger_project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tododb_swagger_project.entity.TodoUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "할일 응답 DTO")
public class TodoUserResponseDto {

    @Schema(description = "할일 ID", example = "1")
    private Long id;

    @Schema(description = "할일 제목", example = "Spring 공부하기")
    private String title;

    @Schema(description = "할일 상세 내용", example = "Security 설정 복습")
    private String description;

    @Schema(description = "마감일", example = "2025-12-31")
    private LocalDate dueDate;

    @Schema(description = "생성일시")
    private LocalDateTime createdAt;

    @Schema(description = "수정일시")
    private LocalDateTime updatedAt;

    public static TodoUserResponseDto from(TodoUser todoUser) {
        TodoUserResponseDto dto = new TodoUserResponseDto();
        dto.setId(todoUser.getId());
        dto.setTitle(todoUser.getTitle());
        dto.setDescription(todoUser.getDescription());
        dto.setDueDate(todoUser.getDueDate());
        dto.setCreatedAt(todoUser.getCreatedAt());
        dto.setUpdatedAt(todoUser.getUpdatedAt());
        return dto;
    }
}