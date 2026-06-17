package org.example.samsung_project.Repository;

import org.example.samsung_project.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>{
    List<Comment> findByPostIdAndDelYnFalseOrderByRegdateAsc(Long PostId);


}