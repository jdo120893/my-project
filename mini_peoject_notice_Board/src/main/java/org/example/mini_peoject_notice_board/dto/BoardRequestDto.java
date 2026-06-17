package org.example.mini_peoject_notice_board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardRequestDto {

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 100, message = "이름은 100자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 255, message = "제목은 255자 이하로 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "암호를 입력해주세요.")
    @Size(min = 4, max = 255, message = "암호는 4자 이상 255자 이하로 입력해주세요.")
    private String password;
}