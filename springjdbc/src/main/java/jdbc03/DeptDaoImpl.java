package jdbc03;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class DeptDaoImpl implements DeptDao {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void insertDept(Dept dept) {
        String sql = "insert into dept(dname,loc) values(?,?)";
        jdbcTemplate.update(sql, dept.getDname(), dept.getLoc());
    }

    @Override
    public void updateDept(Dept dept) {

    }

    @Override
    public void deleteDept(Dept dept) {

    }

    @Override
    public List<Dept> getDepts() {
        return List.of();
    }
}
