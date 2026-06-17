package org.example.junggo_project.junggo.board.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
public class BoardDTO {

    private Integer id;

    @NotEmpty(message = "이름을 입력하세요.")
    private int user_id;
    private String title;
    private String text;
    private int price;
    private int status;
    private int category;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;

//    @Override
//    public  String  toString()  {
//        return
//                "작성자ID:  "  +  user_id  +
//                        "\t  글  제목:  "  +  title  +
//                        "\t  본문:  "  +  text  +
//                        "\t  가격:  "  +  price  +
//                        "\t  제공 상태:  "  +  status  +
//                        "\t  카테고리:  "  +  category  +
//                        "\t  생성시간:  "  +  createAt;
//    }
//    public BoardDTO(){}
//
//    public BoardDTO(int user_id, String title, String text, int price, int status, int category) {
//        this.user_id = user_id;
//        this.title = title;
//        this.text = text;
//        this.price = price;
//        this.status = status;
//        this.category = category;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUser_Id() {
//        return user_id;
//    }
//
//    public void setUser_Id(int user_id) {
//        this.user_id = user_id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public int getCategory() {
//        return category;
//    }
//
//    public void setCategory(int category) {
//        this.category = category;
//    }
//
//    public LocalDateTime getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(LocalDateTime createAt) {
//        this.createAt = createAt;
//    }
//
//    public LocalDateTime getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(LocalDateTime updateAt) {
//        this.updateAt = updateAt;
//    }
//
//    public LocalDateTime getDeleteAt() {
//        return deleteAt;
//    }
//
//    public void setDeleteAt(LocalDateTime deleteAt) {
//        this.deleteAt = deleteAt;
//    }
}
