package springdatajdbc01;


import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Dept, Integer> {
    Dept findByDname(String deptName);

}
