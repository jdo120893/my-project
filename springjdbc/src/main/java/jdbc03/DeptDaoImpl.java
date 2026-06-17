package jdbc03;


import jdbc02.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeptDaoImpl implements DeptDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertDept(Dept dept) {
        String sql = "insert into Dept(dname, loc) values(?,?)";

       try {
           return jdbcTemplate.update(sql, dept.getDname(), dept.getLoc());
       }catch(DataAccessException e) {
           throw new DataAccessResourceFailureException("사용자가 값을 잘못 입력 했어요. "+ dept.getDname(), e);
       }
    }

    @Override
    public List<Dept> findAllDept() {
        String sql = "select * from Dept";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Dept.class));
    }

    @Override
    public Dept findDeptByNo(int deptno) {
        String sql = "select * from Dept where deptno=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dept.class), deptno);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateDept(Dept dept) {
        String sql = "update Dept set dname=?, loc=? where deptno=?";

        int updateCount = jdbcTemplate.update(sql,dept.getDname(),dept.getLoc(),dept.getDeptno());
        if(updateCount == 0){
            throw new UserNotFoundException("부서를 찾을 수 없습니다: " + dept.getDname());
        }
    }

    @Override
    public void deleteDept(int deptno) {
        String sql = "delete from Dept where deptno=?";
        int deleteCount = jdbcTemplate.update(sql,deptno);
        if(deleteCount == 0) {
            throw new UserNotFoundException("부서를 찾을 수 없습니다." + deptno);
        }

    }
}
