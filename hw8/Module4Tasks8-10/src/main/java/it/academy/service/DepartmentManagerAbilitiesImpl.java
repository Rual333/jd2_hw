package it.academy.service;

import it.academy.model.Department;
import it.academy.model.Employee;
import org.springframework.stereotype.Service;

@Service("departmentManagerAbilitiesImpl")
public class DepartmentManagerAbilitiesImpl implements DepartmentManagerAbilities {

    @Override
    public void hire(Department department, Employee employee) {
        department.getEmployees().add(employee);
        System.out.println(employee.getName() + " is hired in " + department.getDepartmentName());
    }

    @Override
    public void fire(Department department, Employee employee) {
        if ( department.getEmployees().remove(employee)) {
            System.out.println(employee.getName() + " fired from " + department.getDepartmentName());
        } else {
            System.out.println(employee.getName() + " aren't working is this department");
        }
    }
}
