package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonMain {
    public static void main(String[] args) {
//        create();
//        update();
        find();
        find2();
    }

    public static void find2(){

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            PassPort passPort = em.find(PassPort.class, 1L);

            log.info("여권 번호 :: {}", passPort.getPassportNumber());
            log.info("여권 리벨링:: {}", passPort.getId());
        }finally {
            em.close();
        }
    }

    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
//            tx.begin();

            Person person = em.find(Person.class, 1L);

            log.info("사람 이름 : {}", person.getName());
            log.info("여권 번호 : {}", person.getPassPort().getPassportNumber());

//            em.persist(person);
//            tx.commit();
        }finally {
            em.close();
        }
    }

    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
//            Person person = em.find(Person.class,1L);
            Person kang = new Person("carami");
            PassPort kpassPort = new PassPort("A1234567");

//            kpassPort.setPerson(kang);
            kang.setPassPort(kpassPort);

            Person urstory = new Person("urstory");
            urstory.setPassPort(new PassPort("B7654321"));


            em.persist(kang);
            em.persist(urstory);

            tx.commit();

        }finally {
            em.close();
        }
    }
}
