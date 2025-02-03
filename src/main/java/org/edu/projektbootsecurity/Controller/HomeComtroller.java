package org.edu.projektbootsecurity.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeComtroller {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", "Du är inloggad");
        return "index";
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "user";
    }


}
