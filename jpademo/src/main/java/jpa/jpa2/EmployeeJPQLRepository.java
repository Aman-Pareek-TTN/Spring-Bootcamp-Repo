package jpa.jpa2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called EmployeeRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface EmployeeJPQLRepository extends CrudRepository<EmployeeJPQL,Integer> {

    @Query("select ej.firstName,ej.lastName from EmployeeJPQL ej where ej.salary>(select avg(ej1.salary) from EmployeeJPQL ej1) order by ej.age,ej.salary desc")
    List<Object []> findAllEmployeeFNameAndLName();

}