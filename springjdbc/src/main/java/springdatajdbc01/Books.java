package springdatajdbc01;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("books")
public class Books {
    @Id
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publish_year;
    private boolean available;
    private LocalDateTime createdAt;

    public Books(String title, String author, String isbn, int publish_year, boolean available, LocalDateTime createdAt) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publish_year = publish_year;
        this.available = available;
        this.createdAt = createdAt;
    }
}
