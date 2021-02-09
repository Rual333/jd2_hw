package it.academy.service;

import it.academy.model.Department;
import it.academy.model.Employee;

public interface DepartmentManagerAbilities {

    public void hire(Department department, Employee employee);

    public void fire(Department department,Employee employee);
}
