package org.example.tododb_swagger_project.service;

import lombok.RequiredArgsConstructor;
import org.example.tododb_swagger_project.dto.TodoUserRequestDto;
import org.example.tododb_swagger_project.dto.TodoUserResponseDto;
import org.example.tododb_swagger_project.entity.TodoUser;
import org.example.tododb_swagger_project.repository.TodoUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoUserService {

    private final TodoUserRepository todoUserRepository;

    // 할일 추가
    public TodoUserResponseDto create(TodoUserRequestDto requestDto) {
        TodoUser todoUser = new TodoUser();
        todoUser.setTitle(requestDto.getTitle());
        todoUser.setDescription(requestDto.getDescription());
        todoUser.setDueDate(requestDto.getDueDate());
        return TodoUserResponseDto.from(todoUserRepository.save(todoUser));
    }

    // 전체 목록 조회
    public List<TodoUserResponseDto> findAll() {
        return todoUserRepository.findAll()
                .stream()
                .map(TodoUserResponseDto::from)
                .collect(Collectors.toList());
    }

    // 단건 조회
    public TodoUserResponseDto findById(Long id) {
        TodoUser todoUser = todoUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 할일이 없습니다. id=" + id));
        return TodoUserResponseDto.from(todoUser);
    }

    // 수정
    public TodoUserResponseDto update(Long id, TodoUserRequestDto requestDto) {
        TodoUser todoUser = todoUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 할일이 없습니다. id=" + id));
        todoUser.setTitle(requestDto.getTitle());
        todoUser.setDescription(requestDto.getDescription());
        todoUser.setDueDate(requestDto.getDueDate());
        return TodoUserResponseDto.from(todoUserRepository.save(todoUser));
    }

    // 삭제
    public void delete(Long id) {
        TodoUser todoUser = todoUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 할일이 없습니다. id=" + id));
        todoUserRepository.delete(todoUser);
    }
}