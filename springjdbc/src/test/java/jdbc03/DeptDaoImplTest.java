package jdbc03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class DeptDaoImplTest {

    @Autowired
    private DeptDao deptDao;

    @BeforeEach
    void setUp() {
        log.info("BeforeEach DeptDaoImplTest");
        Math.random();
        random();
        abs(random());
    }

    @AfterEach
    void tearDown() {
        log.info("AfterEach DeptImplTest");

    }

    @Test
    void insertDept() {
        log.info("insertDept DeptImplTest");
        Dept dept = new Dept();
        dept.setDname("Programming Team");
        dept.setLoc("seoul");
        int count = deptDao.insertDept(dept);
        assertThat(count).isEqualTo(1);
    }

    @Test
    void findAllDept() {
        log.info("findAllDept DeptDaoImplTest");
        List<Dept> depts = deptDao.findAllDept();
        assertThat(depts).hasSize(4);
        assertThat(depts.get(0).getDname()).isEqualTo("Programing Team");
    }

    @Test
    void findDeptByNo() {
        log.info("findDeptByNo DeptDaoImplTest");
        Dept dept = deptDao.findDeptByNo(1);
        assertThat(dept).isNotNull();
        assertThat(dept.getDname()).isEqualTo("Programing Team");
    }

    @Test
    void updateDept() {
        log.info("updateDept DeptImplTest");
        Dept dept = new Dept();
        dept.setDeptno(1);
        dept.setDname("Develoment Team");
        dept.setLoc("seoul");

        deptDao.updateDept(dept);
        Dept updateDept = deptDao.findDeptByNo(1);
        assertThat(updateDept.getDname()).isEqualTo("Devaloment Test");
        assertThat(updateDept.getLoc()).isEqualTo("seoul");
    }

    @Test
    void deleteDept() {
        log.info("deleteDept DeptImplTest");
        deptDao.deleteDept(1);
        assertThatThrownBy(() -> deptDao.findDeptByNo(1)).isInstanceOf(EmptyResultDataAccessException.class);
    }
}