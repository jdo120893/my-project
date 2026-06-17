package org.example.junggo_project.junggo.user.dao;


import org.example.junggo_project.junggo.user.dto.UserDTO;

public interface UserDAO {
   boolean insertUser(UserDTO userDTO);
   UserDTO login(String email, String pw);

}
