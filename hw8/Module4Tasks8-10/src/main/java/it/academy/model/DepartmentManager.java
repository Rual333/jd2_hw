package it.academy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import it.academy.service.DepartmentManagerAbilities;

@Component("departmentManager")
@ToString
@Getter
@Setter
public class DepartmentManager {

    @Autowired
    @Value("#{department}")
    private Department department;

    @Autowired
    @Qualifier("itDepartmentManagerAbilitiesImpl")
    private DepartmentManagerAbilities departmentManagerAbilities;
}
