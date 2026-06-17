package org.example.restexam.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.restexam.dto.TodoDTO;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todos")
@Entity
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String todo;
    private boolean done;

    public static Todo formDTO(TodoDTO dto){
        return Todo.builder()
                .id(dto.getId())
                .todo(dto.getTodo())
                .done(dto.isDone())
                .build();
    }
}
