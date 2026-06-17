package org.example.restexam.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.restexam.Domain.Todo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {
    private Long id;
    @NotBlank(message = "할일은 반드시 있어야합니다.")
    private String todo;
    private boolean done;

    public static TodoDTO fromEntity(Todo td){
        return TodoDTO.builder()
                .id(td.getId())
                .todo(td.getTodo())
                .done(td.isDone())
                .build();
    }
}
