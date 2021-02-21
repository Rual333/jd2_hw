package it.academy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class PersonController {

    @PostMapping("/addPerson")
    public String addPerson(@ModelAttribute("person") Person person) {
        return "redirect:person.html";
    }

    @GetMapping("/person")
    public String showContacts(Model model) {
        model.addAttribute("command", new Person());
        return "person";
    }
}
