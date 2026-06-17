package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.Domain.Todo;
import org.example.restexam.dto.TodoDTO;
import org.example.restexam.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository repository;

    @Transactional(readOnly = true)
    public List<TodoDTO> getTodos(){
        return repository.findAll().stream().map(TodoDTO::fromEntity).toList();
    }

    @Transactional(readOnly = true)
    public TodoDTO getTodo(Long id){
        Todo todo = repository.findById(id).orElseThrow(() -> new RuntimeException("할일을 찾을 수 없습니다." + id));
        return TodoDTO.fromEntity(todo);
    }

    @Transactional
    public TodoDTO createTodo(TodoDTO todoDTO){
        Todo todo = repository.save(Todo.formDTO(todoDTO));
        return TodoDTO.fromEntity(todo);
    }

    @Transactional
    public TodoDTO updateTodo(TodoDTO todoDTO){
        Todo todo = repository.findById(todoDTO.getId()).orElseThrow(()->new RuntimeException("찾을 수 없습니다"+todoDTO.getId()));

//        if (todoDTO.getTodo() != null)
//            todo.setTodo(todoDTO.getTodo());

        Optional.ofNullable(todoDTO.getTodo()).ifPresent(todo::setTodo);


        return TodoDTO.fromEntity(todo);
    }

    @Transactional
    public void deleteTodo(Long id){

        if (!repository.existsById(id))
            throw new  RuntimeException("찾을수 없습니다."+id);
        repository.deleteById(id);
    }
}

