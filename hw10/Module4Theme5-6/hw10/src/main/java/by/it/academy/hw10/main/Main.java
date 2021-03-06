package by.it.academy.hw10.main;

import by.it.academy.hw10.data.DaoConfiguration;
import by.it.academy.hw10.model.Planet;
import by.it.academy.hw10.test.PlanetSaveAndReadService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new    AnnotationConfigApplicationContext(DaoConfiguration.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PlanetSaveAndReadService service = context.getBean(PlanetSaveAndReadService.class);
        Planet planet = new Planet(1L,"Mars", 64e22, 3389, 3.711);

        service.save(planet);

        Planet jobCandidate = service.read(1L);
        System.out.println(jobCandidate);

    }
}
