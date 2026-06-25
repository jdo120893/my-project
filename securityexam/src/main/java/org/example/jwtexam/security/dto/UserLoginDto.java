package org.example.jwtexam.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
