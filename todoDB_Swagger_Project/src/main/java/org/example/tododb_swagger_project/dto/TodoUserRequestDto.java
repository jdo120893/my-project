package org.example.tododb_swagger_project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "할일 요청 DTO")
public class TodoUserRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    @Schema(description = "할일 제목", example = "Spring 공부하기")
    private String title;

    @Schema(description = "할일 상세 내용", example = "Security 설정 복습")
    private String description;

    @NotNull(message = "마감일은 필수입니다.")
    @Schema(description = "마감일", example = "2025-12-31")
    private LocalDate dueDate;
}