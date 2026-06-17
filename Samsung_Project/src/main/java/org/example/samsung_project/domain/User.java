package org.example.samsung_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "login_id", nullable = false, unique = true, length = 100)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @CreationTimestamp
    @Column(name = "joined_date", updatable = false)
    private LocalDateTime joinedDate;

    // 권한 관리를 위한 필드 (기본값: USER)
    @Column(nullable = false)
    private String role = "USER";
}