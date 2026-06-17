package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentMain {
    public static void find() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            School school = entityManager.find(School.class, 2L);
            log.info("School Name : {}", school.getName());
            log.info("fetch 전략을 확인해봅시다.");
            log.info("Student size: {}", school.getStudents().size());

            Student student = entityManager.find(Student.class, 9L);
            log.info("Student name: {}", student.getName());
            log.info("school name: {}", student.getSchool().getName());
        }finally {
            entityManager.close();
        }
    }

    public static void create() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
//            School school = new School("lion school");
//            entityManager.persist(school);

//            School school = entityManager.find(School.class, 3L);
//            Student student = new Student("강경미",school);
//
//            entityManager.persist(student);

//            entityManager.persist(new Student("aaa",new School("like chool")));

            School school = new School("mutsa school");

            school.getStudents().add(new Student("abc",school));
            school.getStudents().add(new Student("bbb",school));
            school.getStudents().add(new Student("ccc",school));
            school.getStudents().add(new Student("ddd",school));

            entityManager.persist(school);


            entityManager.getTransaction().commit();

        }finally {
            entityManager.close();
        }
    }

    public static void update(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {

            Student student = entityManager.find(Student.class, 4L);
            student.setName("carami");

            entityManager.getTransaction().commit();

        }catch (Exception e) {
            entityManager.getTransaction().rollback();

            throw e;

        }finally {
            entityManager.close();
        }
    }

    public static void delete(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            School school = entityManager.find(School.class, 3L);
            entityManager.remove(school);

            entityManager.getTransaction().commit();

        }finally {
            entityManager.close();
        }
    }
    public static void main(String[] args) {

        find();
//        create();
//        update();
//        delete();
    }
}
