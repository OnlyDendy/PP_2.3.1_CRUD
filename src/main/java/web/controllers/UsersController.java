package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Users;
import web.service.UserDaoImpl;

@Controller
@RequestMapping("/people")
public class UsersController {

    private final UserDaoImpl userDAO;

    @Autowired
    public UsersController(UserDaoImpl userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String UserIndex(Model model) {

        model.addAttribute("people", userDAO.index());
        return "people/allUsers";
    }

    @GetMapping("/{id}")
    public String showUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("users") Users users) {
        return "people/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("users") Users users) {
        userDAO.save(users);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") Users users, @PathVariable("id") int id) {
        userDAO.update(id, users);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/people";
    }
}
