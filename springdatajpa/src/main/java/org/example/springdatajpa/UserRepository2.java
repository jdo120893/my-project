package org.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository2 extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    List<User> findUserByName(String name);

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.email = :email")
    User findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:Keyword%")
    List<User> searchByEmailKeyword(@Param("keyword") String keyword);

    @Query("SELECT s FROM Student s JOIN FETCH s.school WHERE s.school.id = :schoolId")
    List<Student> findStudentBySchoolId(@Param("schoolId") Long schoolID);

    @Query("SELECT COUNT(u) FROM User u WHERE u.name = :name")
    long countUserByName(@Param("name") Long name);

    @Query("SELECT new org.example.dto.UserDto(u.name, u.email) FROM User u")
    List<UserDto> findAllUserDtos;

    @Query(value = "SELECT * FROM jpa_user WHERE name = :name", nativeQuery = true)
    List<User> findByNameNative(@Param("name") String name);

    @Query(value = "SELECT * FROM jpa_user WHERE email LIKE %?1%", nativeQuery = true)
    List<User> findByEmailNative(String email);

    @Query(value = "SELECT * FROM jpa_user WHERE YEAR(created_date) = :year", nativeQuery = true)
    List<User> findUsersByYear(@Param("year") int year);
}
