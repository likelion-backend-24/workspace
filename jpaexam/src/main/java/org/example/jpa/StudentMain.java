package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentMain {
    public static void find(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            School school = entityManager.find(School.class, 2L);
            log.info("School Name : {}", school.getName());
            log.info("fetch 전략을 확인해봅시다.");
            log.info("Student info : {}", school.getStudents().size());

            Student student = entityManager.find(Student.class, 9L);
            log.info("Student name : {}", student.getName());
            log.info("fetch 전략을 확인해봅시다.");
            log.info("School Name : {}", student.getSchool().getName());
        }finally {
            entityManager.close();
        }
    }
//    생성
    public static void create(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
//            학교를 하나 추가해볼까요??
//            School school = new School("lion school");
//            entityManager.persist(school);

//            학생을 추가해보세요.
//            School school = entityManager.find(School.class, 3L);
//            Student student = new Student("강경미",school);
//
//            entityManager.persist(student);

//            entityManager.persist(new Student("aaa",new School("like school")));

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

//    수정
    public static void update(){
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            try {

                Student student = entityManager.find(Student.class, 4L);
                student.setName("carami");

                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
            finally {
                entityManager.close();
            }
        }


//    삭제
public static void delete(){
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    entityManager.getTransaction().begin();
    try {
//        Student student = entityManager.find(Student.class, 4L);
//        entityManager.remove(student);

        School school = entityManager.find(School.class, 1L);
        entityManager.remove(school);

        entityManager.getTransaction().commit();
    }finally {
        entityManager.close();
    }
}
    public static void main(String[] args) {
//          조회
       find();
//        create();
//        update();
//        delete();
    }
}
