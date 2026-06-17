package org.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);

    @Query("SELECT u FROM User u where u.name = ?1")
    List<User> getUserName(String name);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> selectUser(@Param("name")String name);
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> selectUserLike(@Param("name") String name);


    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.email = :email")
    int deleteByEmail(@Param("email")String email);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.email = :email WHERE u.id=:id")
    int updateByEmail(@Param("id")Long id, @Param("email")String email);


    // 기본 Native SQL - 전체 엔티티 조회
    @Query(value = "SELECT * FROM lion_user WHERE name = :name", nativeQuery = true)
    List<User> findByNameNative(@Param("name") String name);

    // LIKE 검색
    @Query(value = "SELECT * FROM lion_user WHERE email LIKE %?1%", nativeQuery = true)
    List<User> findByEmailNative(String email);

    // 데이터베이스 함수 사용
    @Query(value = "SELECT * FROM lion_user WHERE YEAR(created_date) = :year",
            nativeQuery = true)
    List<User> findUsersByYear(@Param("year") int year);


}