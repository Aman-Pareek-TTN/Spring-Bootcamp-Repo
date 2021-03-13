package com.jpql.jpqldemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //JPQL

    @Query("select e.firstName,e.lastName from Employee e where e.salary>(select avg(salary) from Employee) order by e.age ASC,e.salary DESC")
    List<Object[]> findAllEmployee();

    @Modifying
    @Query("update Employee SET salary = ?1 where salary<(select avg(salary) from Employee)")
    void updateSalary(int salary);

    @Modifying
    @Query("delete from Employee e where e.salary=(select min(salary) from Employee)")
    void deleteEmployee();


    //Native SQL Query:

    @Query(value = "select e.empid,e.empfirstname,e.empage from employee e where e.emplastname =:lastname", nativeQuery = true)
    List<Object[]> findEmployeeNQ(@Param("lastname") String lastName);


    @Modifying
    @Query(value = "delete from employee e where e.empage >:empAge ", nativeQuery = true)
    void deleteEmployeeNQ(@Param("empAge") int empAge);
}
