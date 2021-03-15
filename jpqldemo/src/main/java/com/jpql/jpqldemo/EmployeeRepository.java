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

    //jpql q1
    @Query("select e.firstName,e.lastName from Employee e where e.salary>(select avg(salary) from Employee) order by e.age ASC,e.salary DESC")
    List<Object[]> findAllEmployee();

    //jpql q2
    @Modifying
    @Query("update Employee SET salary =:updatedSal  where salary<:avgSal")
    void updateSalary(@Param("avgSal") int avgSal,@Param("updatedSal") int salary);

    //jpql q3
    @Modifying
    @Query("delete from Employee e where e.salary=:minSal")
    void deleteEmployee(@Param("minSal") int minSal);

    @Query("select avg(salary) from Employee")
    int findAvgEmployeeSalary();

    @Query("select min(salary) from Employee")
    int findMinEmployeeSalary();


    //Native SQL Query:

    //jpql q4
    @Query(value = "select e.emp_id,e.emp_first_name, e.emp_age from employee_table e where e.emp_last_name =:lastname", nativeQuery = true)
    List<Object[]> findEmployeeNQ(@Param("lastname") String lastName);


    //jpql q5
    @Modifying
    @Query(value = "delete from employee_table where emp_age > :empAge ", nativeQuery = true)
    void deleteEmployeeNQ(@Param("empAge") int empAge);
}
