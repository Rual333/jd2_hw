package it.academy.main;

import it.academy.model.ComponentScanNotIgnoredClass;
import it.academy.model.Department;
import it.academy.model.DepartmentManager;
import it.academy.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.Arrays;


@ComponentScan(basePackages = "it.academy",
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ComponentScanNotIgnoredClass.class))
public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        final Department department = context.getBean(Department.class);
        final DepartmentManager departmentManager = context.getBean(DepartmentManager.class);
        final Employee employee1 = context.getBean(Employee.class);
        employee1.setName("Tim");
        final Employee employee2 = context.getBean(Employee.class);
        employee2.setName("John");

        System.out.println(department);
        System.out.println(departmentManager);
        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println("\nHiring employee in IT Department");
        departmentManager.getDepartmentManagerAbilities().hire(department, employee1);

        departmentManager.getDepartmentManagerAbilities().hire(department, employee2);
        System.out.println("salary is " + employee1.getSalary() + " now");

        System.out.println(department.getEmployees());
    }
}
