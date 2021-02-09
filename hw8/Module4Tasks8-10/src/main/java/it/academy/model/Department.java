package it.academy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("department")
@Getter
@Setter
@PropertySource("classpath:department.properties")
@ToString
public class Department {

    @Autowired
    @Value("#{employee}")
    private Employee chef;

    @Value("${department.name}")
    private String departmentName;

    private List<Employee> employees = new ArrayList<>();

}
