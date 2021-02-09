package it.academy.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("employee")
@Getter
@Setter
@PropertySource("classpath:employee.properties")
@ToString
public class Employee {

    @Value("${employee.name}")
    private String name;

    @Autowired(required = false)
    private Date birthdayDate;

    @Value("${employee.contacts}")
    private String contacts;

    @Value("${employee.salary}")
    private Integer salary;

}
