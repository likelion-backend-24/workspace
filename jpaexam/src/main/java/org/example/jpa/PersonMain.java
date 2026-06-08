package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonMain {
    public static void main(String[] args) {
//        create();
        find();
        find2();
    }
    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try{
            Person person = em.find(Person.class, 1);

            log.info("person :: {}",person.getName());
            log.info("passport number :: {}",person.getPassport().getPassportNumber());

        }finally {
            em.close();
        }

    }

    public static void find2(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try{
            Passport passport = em.find(Passport.class, 1L);

            log.info("passport :: {}",passport.getPassportNumber());
            log.info(" :: {}",passport.getPerson().getName());

        }finally {
            em.close();
        }

    }
    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Person kang = new Person("carami");
            Passport kPassport = new Passport("A1234567");

//            kPassport.setPerson(kang);
            kang.setPassport(kPassport);

            Person urstory = new Person("urstory");
            urstory.setPassport(new Passport("B7654321"));


            em.persist(kang);
            em.persist(urstory);



            tx.commit();
        }finally {
            em.close();
        }
    }
}
