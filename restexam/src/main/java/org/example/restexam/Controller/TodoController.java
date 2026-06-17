package org.example.restexam.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restexam.dto.TodoDTO;
import org.example.restexam.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping(value = "/xml", produces = "/application/xml")
    public ResponseEntity<List<TodoDTO>> getTodosAsxml(){
        List<TodoDTO> todoDTOS = Arrays.asList(
                new TodoDTO(1L,"공부",true),
        new TodoDTO(1L,"조깅",true),
        new TodoDTO(1L,"달리기",false));

        return ResponseEntity.ok(todoDTOS);
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getTodos(@RequestHeader("Accept") String acceptHeader){
        System.out.println(acceptHeader);
    return ResponseEntity.ok(todoService.getTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TodoDTO>> getTodo(@PathVariable Long id){

        return ResponseEntity.ok(todoService.getTodos());
    }

    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(@Valid @RequestBody TodoDTO todoDTO){

//        if (ProductDTO.getName()!=null)
        TodoDTO todoDTO1 = todoService.createTodo(todoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoDTO1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("id")Long id, @RequestBody TodoDTO todoDTO){
        todoDTO.setId(id);
        return ResponseEntity.ok(todoService.updateTodo(todoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
