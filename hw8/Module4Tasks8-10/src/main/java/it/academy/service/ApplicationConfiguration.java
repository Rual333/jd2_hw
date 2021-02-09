package it.academy.service;

import it.academy.model.Department;
import it.academy.model.DepartmentManager;
import it.academy.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;


@Configuration
public class ApplicationConfiguration {

    @Bean
    @Scope("prototype")
    Department department() {
        return new Department();
    }

    @Bean
    @Scope("prototype")
    Employee employee() {
        return new Employee();
    }

    @Bean
    DepartmentManager departmentManager() {
        return new DepartmentManager();
    }

    @Bean
    DepartmentManagerAbilitiesImpl departmentManagerAbilitiesImpl() {
        return  new DepartmentManagerAbilitiesImpl();
    }

    @Bean
    @Primary
    ITDepartmentManagerAbilitiesImpl itDepartmentManagerAbilitiesImpl() {
        return  new ITDepartmentManagerAbilitiesImpl();
    }

}
