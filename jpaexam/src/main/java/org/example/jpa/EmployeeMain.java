package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeMain {
    public static void main(String[] args) {
//        create();
//        find();
        update();
//        delete();
    }


    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            

        }finally {

        }
    }
    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

       try{ Employee employee = em.find(Employee.class, 1L);
        employee.setName("carami");

        em.persist(employee);
        em.getTransaction().commit();
       }finally {
           em.close();
       }
    }

    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//        em.getTransaction().begin();

        try{
            Employee employee = em.find(Employee.class, 1L);
            log.info("직원 이름 : {}", employee.getName());

            Project project = em.find(Project.class, 1L);
            log.info("프로젝트 제목 : {}",  project.getTitle());

            for (Employee e: project.getEmployees()){
                log.info("직원 이름 : {}", e.getName() );
            }




        }finally {
            em.close();
        }
    }

    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{Employee employee = new Employee("kang");


        Project project = new Project();
        project.setTitle("perfect project");

//            Project project = em.find(Project.class, 1L);

            employee.getProjects().add(project);
            project.getEmployees().add(employee);



        em.persist(employee);
        em.persist(project);

        em.getTransaction().commit();
        }finally{
            em.close();
        }

    }
}
