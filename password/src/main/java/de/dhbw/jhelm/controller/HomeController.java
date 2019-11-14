package de.dhbw.jhelm.controller;

import de.dhbw.jhelm.domain.User;
import de.dhbw.jhelm.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        User user = authenticationService.getLoggedInUser();
        model.addAttribute("name", user.getId());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        return "greeting";
    }

}
