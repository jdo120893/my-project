package org.example.junggo_project.junggo.user.dao;


import org.example.junggo_project.junggo.common.DBUtil;
import org.example.junggo_project.junggo.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserDAOImpl implements UserDAO{


    // 회원가입
    public boolean insertUser(UserDTO userDto){
        boolean result = false;

        String sql = "insert into user(email, password, name, address, phone_number) values(?,?,?,?,?)";

        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, userDto.getEmail());
            ps.setString(2, userDto.getPassword());
            ps.setString(3, userDto.getName());
            ps.setString(4, userDto.getAddress());
            ps.setString(5, userDto.getPhone_number());
            int count = ps.executeUpdate();
            if(count == 1)
                result = true;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
    //로그인
    public UserDTO login(String email, String pw) {
        //조회
        String sql = "select * from user where email = ? and password = ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, email);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDTO dto = new UserDTO();

                dto.setId(rs.getInt("id"));
                dto.setEmail(rs.getString("email"));
                dto.setPassword(rs.getString("passWord"));
                dto.setName(rs.getString("name"));
                dto.setAddress(rs.getString("address"));
                dto.setPhone_number(rs.getString("phone_number"));
                return dto;
            }
        } catch(Exception e){
                System.out.println(e.getMessage());
            }
        return null;
        }
    }
