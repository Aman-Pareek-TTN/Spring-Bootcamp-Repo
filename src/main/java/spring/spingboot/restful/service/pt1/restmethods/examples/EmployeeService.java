package spring.spingboot.restful.service.pt1.restmethods.examples;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service //Ques 2
public class EmployeeService {


    //EmployeeListGetter employeeListGetter;

    public static List<Employee> employeeList;

    static {

        employeeList= Arrays.asList(
                new Employee("1","aman","jvm",23),
                new Employee("2","jai","spring",25),
                new Employee("3","joss","linux",28),
                new Employee("4","ray","it",21),
                new Employee("5","ram","jvm",50),
                new Employee("6","mark","python",38),
                new Employee("7","ashish","linux",42)
        );

    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /*
    Employee List setter
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
*/

    public void insertEmployee(Employee employee)
    {
        employeeList.add(employee);
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

}
