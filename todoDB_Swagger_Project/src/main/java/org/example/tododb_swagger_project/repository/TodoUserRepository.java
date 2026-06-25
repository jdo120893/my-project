package org.example.tododb_swagger_project.repository;


import org.example.tododb_swagger_project.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoUserRepository extends JpaRepository<TodoUser,Long> {
    // 마감일 기준 조회
    List<TodoUser> findByDueDateBefore(LocalDate date);
}
