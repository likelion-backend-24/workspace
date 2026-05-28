package jdbc03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DeptDaoImplTest {
    @Autowired
    DeptDao deptDao;

    @Test
    void insertDept() {
        Dept dept=new Dept("마케팅","대구");

        deptDao.insertDept(dept);


    }
}