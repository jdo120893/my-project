package org.example.junggo_project.junggo.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
    @NotEmpty (message = "이름을 입력 해주세요.")
    private int id;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phone_number;
    private Double manner;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;


//    public UserDTO(int id, String email, String password, String name, String address, String phone_number) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.phone_number = phone_number;
//    }
//
//    public UserDTO() {
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhone_number() {
//        return phone_number;
//    }
//
//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }
//
//    public Double getManner() {
//        return manner;
//    }
//
//    public void setManner(Double manner) {
//        this.manner = manner;
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
