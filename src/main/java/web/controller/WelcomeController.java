package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap modelMap) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome!");
        modelMap.addAttribute("messages", messages);
        return "index";
    }

}
