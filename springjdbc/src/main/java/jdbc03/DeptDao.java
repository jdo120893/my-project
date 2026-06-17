package jdbc03;


import java.util.List;

public interface DeptDao {
    int insertDept(Dept dept);
    List<Dept> findAllDept();
    Dept findDeptByNo(int deptno);
    void updateDept(Dept dept);
    void deleteDept(int deptno);
}
