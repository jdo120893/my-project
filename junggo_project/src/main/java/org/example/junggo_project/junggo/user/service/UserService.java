package org.example.junggo_project.junggo.user.service;


import org.example.junggo_project.junggo.user.dto.UserDTO;

public interface UserService {
    boolean insertUser(UserDTO userDTO);
    UserDTO login(String email, String pw);
}
