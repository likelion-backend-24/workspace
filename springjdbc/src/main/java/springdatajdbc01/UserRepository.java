package springdatajdbc01;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>,CustomUserRepository {
//    이름을 기준으로 조회하고 싶다면?
    List<User> findByName(String name);  //select * from users where name=?
    List<User> findByEmail(String email);
//    findByName   -  쿼리 메서드.
//    findByNameContaining   select * from users where name like %keyword%;
}
