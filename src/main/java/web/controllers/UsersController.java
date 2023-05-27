package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Users;
import web.service.UserService;

@Controller
@RequestMapping("/people")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String UserIndex(Model model) {
        model.addAttribute("people", userService.index());
        return "people/allUsers";
    }

    @GetMapping("/{id}")
    public String showUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("users") Users users) {
        return "people/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("users") Users users) {
        userService.save(users);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("users", userService.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") Users users, @PathVariable("id") long id) {
        userService.update(id,users);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/people";
    }
}
