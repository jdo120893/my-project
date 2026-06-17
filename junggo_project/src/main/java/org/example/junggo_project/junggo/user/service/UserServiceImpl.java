package org.example.junggo_project.junggo.user.service;


import org.example.junggo_project.junggo.user.dao.UserDAO;
import org.example.junggo_project.junggo.user.dao.UserDAOImpl;
import org.example.junggo_project.junggo.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
//    private UserDAO userDAO = new UserDAOImpl();

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean insertUser(UserDTO userDTO){

        return userDAO.insertUser(userDTO);
    }



    //로그인 예외처리
    public UserDTO login(String email, String pw){
        UserDTO dto = userDAO.login(email,pw);
        if(dto!=null) {
            System.out.println(dto.getName() + "로그인 성공");
            return dto;
        } else {
            System.out.println("로그인 실패");
            return null;
        }
    }
}