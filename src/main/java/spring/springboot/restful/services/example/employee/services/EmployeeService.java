package spring.springboot.restful.services.example.employee.services;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //pt1 Ques 2
public class EmployeeService {


    //EmployeeListGetter employeeListGetter;

    public static final List<Employee> employeeList;

    static {

        employeeList=new ArrayList<>();
        employeeList.add( new Employee("1","aman","jvm",23));
        employeeList.add(new Employee("2","jai","spring",25));
        employeeList.add( new Employee("3","joss","linux",28));
        employeeList.add(  new Employee("4","ram","jvm",50));
    }

    public EmployeeService() {

    }


    public List<Employee> getEmployeeList() {

        return employeeList;
    }


    public void insertEmployee(Employee employee)
    {
        employeeList.add(employeeList.size()-1,employee);
        System.out.println("Employee added");
    }

    public Employee deleteEmployee(String id)
    {
        for(Employee tempEmployee : employeeList)
        {
            if(id.equalsIgnoreCase(tempEmployee.getId()))
            {
                employeeList.remove(tempEmployee);
                return tempEmployee;
            }
        }

        System.out.println("Employee doesn't exist");
        return null;
    }

    public Employee getTopEmployee()
    {

        return employeeList.get(0);
    }

    public Employee getEmployee(String id)
    {
        for(Employee tempEmployee : employeeList)
        {
            if(id.equalsIgnoreCase(tempEmployee.getId()))
            {
                return tempEmployee;
            }
        }

        System.out.println("Employee doesn't exist");
        return null;

    }

    public Employee getEmployeeByName(String name)
    {
        for(Employee tempEmployee : employeeList)
        {
            if(name.equalsIgnoreCase(tempEmployee.getName()))
            {
                return tempEmployee;
            }
        }

        System.out.println("Employee doesn't exist");
        return null;

    }

    public void updateEmployeeId(String id1, String id2)
    {
        for(Employee tempEmployee : employeeList) {
            if (id1.equalsIgnoreCase(tempEmployee.getId())) {
                tempEmployee.setId(id2);
                break;
            }
        }
    }

}
