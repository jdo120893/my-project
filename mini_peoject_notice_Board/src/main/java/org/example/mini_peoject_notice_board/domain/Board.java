package org.example.mini_peoject_notice_board.domain;

import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor // Spring Data JDBC가 내부적으로 객체를 생성할 때 사용합니다.
@Table("board")
public class Board {

    @Id
    private Long id;
    private String name;
    private String title;
    private String content;
    private String password;

    // 💡 1. 필드 레벨에서 기본값 선언 (NPE 방지 및 새 글 저장 시 자동 할당)
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    // 💡 2. primitive 타입인 int는 초기값을 주지 않아도 기본적으로 0으로 세팅됩니다.
    private int viewCount = 0;

    // 새 글 작성을 위한 생성자
    public Board(String name, String title, String content, String password) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.password = password;
        // 위에서 필드 초기화를 해두었기 때문에 생성자에서 명시적으로 지워도 안전하지만,
        // 확실히 하기 위해 명시해 두는 것도 좋습니다.
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}