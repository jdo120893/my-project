package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaRun {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //트랜잭션 시작
        entityManager.getTransaction().begin();

//        User user = new User("carami_11","carami@carami.com"); //비영속
//        user.setId(1L);
//
//        User user = entityManager.find(User.class,1L);
//        user.setName("new_carami");
//
//        User user2 = new User("carami_22","carami@carami.com"); //비영속
//        user2.setId(4L);
//
//        User user3 = new User("홍길동","hong@hong.com");
//
//        System.out.println("persist 실행전!!");
////        entityManager.persist(user); // 영속상태
//        entityManager.persist(user3);
//        System.out.println("persist 실행후!!");




        //조회 영속성 컨텍스트에서 찾고 없으면 DB에서 찾는다.
        User fUser = entityManager.find(User.class,1L);
        User fUser2 = entityManager.find(User.class, 2L);

        if(fUser == fUser2)
            System.out.println("같은 인스턴스.");

        //수정 - 트랜잭션이 종료되는 시점에 영속성 컨텍스트를 분석해서 결정함!!
        fUser.setName("caramif");
        fUser2.setName("caramif2");

        //삭제
        User delUser = entityManager.find(User.class, 1L);
        entityManager.remove(delUser);


        System.out.println("commit 실행 전");
        entityManager.getTransaction().commit();
        System.out.println("commit 실행 후");

        entityManager.close();
        entityManagerFactory.close();
    }

}
