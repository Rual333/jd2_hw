package it.academy.service;

import it.academy.model.Department;
import it.academy.model.Employee;
import org.springframework.stereotype.Service;

@Service("itDepartmentManagerAbilitiesImpl")
public class ITDepartmentManagerAbilitiesImpl implements DepartmentManagerAbilities {

    @Override
    public void hire(Department department, Employee employee) {
        employee.setSalary(employee.getSalary()+1000);
        department.getEmployees().add(employee);
        System.out.println(employee.getName() + " is hired in IT department (such a lucky person)");

    }

    @Override
    public void fire(Department department, Employee employee) {
        if ( department.getEmployees().remove(employee)) {
            System.out.println(employee.getName() + " fired from IT department" + department.getDepartmentName());
        } else {
            System.out.println(employee.getName() + " aren't working is this department");
        }
    }

}
