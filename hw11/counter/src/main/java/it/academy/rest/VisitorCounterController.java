package it.academy.rest;

import it.academy.service.VisitorCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class VisitorCounterController {

    @Autowired
    VisitorCounterService visitorCounterService;

    @GetMapping("/visitor_count")
    public int readVisitorCount() {
        return visitorCounterService.readCount();
    }

    @PutMapping("/visitor_count")
    public int updateVisitorCount() {
        return visitorCounterService.updateCount();
    }
}
