package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Vehicle2Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            Car2 car = new Car2();
            car.setManufacturer("lion compony");
            car.setSeatCount(3);

            Truck2 t = new Truck2();
            t.setManufacturer("carami compony");
            t.setPayloadCapacity(200);

            em.persist(t);



            em.persist(car);

            em.getTransaction().commit();

        }finally{
            em.close();
        }
    }
}
