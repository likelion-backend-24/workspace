package jdbc03;

import java.util.List;

public interface DeptDao {
    void insertDept(Dept dept);
    void updateDept(Dept dept);
    void deleteDept(Dept dept);
    List<Dept> getDepts();
}
