package org.example.samsung_project.Repository;

import org.example.samsung_project.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>{
    Page<Post> findByTitleContaining(String Keyword,Pageable pageable);
}