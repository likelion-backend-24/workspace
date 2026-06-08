package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeMain {
    public static void main(String[] args) {
//        create();
//        find();
//        update();
//        find();
        delete();
    }
    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class, 1L);
            em.remove(employee);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class, 3L);
            employee.setName("ccccc");

            employee.getProjects().add(em.find(Project.class,3L));

            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try{
// 1L id 사원 정보 출력
            Employee employee = em.find(Employee.class, 3L);
            log.info("사원이름 : {}",employee.getName());

            for(Project p : employee.getProjects()){
                log.info("프로젝트 : {}",p.getTitle());
            }

//            // id 가 1L 프로젝트 정보를 출력해보세요.
//            Project project = em.find(Project.class, 1L);
//            log.info("프로젝트명 : {}",project.getTitle());
//            //1번 프로젝트에 참여한 사원 정보도 출력해 주세요.
//            for(Employee e : project.getEmployees()){
//                log.info("사원 이름 : {}",e.getName());
//            }



       }finally {
            em.close();
        }
    }

    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = new Employee("carami");

            Project project = new Project();
            project.setTitle("lion project");

//            Project project = em.find(Project.class, 1L);

//            employee.getProjects().add(project);
//            project.getEmployees().add(employee);

            employee.addProject(project);

            em.persist(employee);


            em.getTransaction().commit();


        }finally {
            em.close();
        }
    }
}
