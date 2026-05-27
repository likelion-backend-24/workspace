package jdbc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Jdbc01Exam implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Jdbc01Exam.class, args);
    }



    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        // 나는 프레임워크에게 알려줘야 할 것은 무엇일까??
        String sql = "insert into users(name,email) values(?,?)";
        int resultCount = jdbcTemplate.update(sql, "kang", "kang@gamilc.om");
        System.out.println(resultCount);

    }
}
