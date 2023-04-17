package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/")
    public String createUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}
