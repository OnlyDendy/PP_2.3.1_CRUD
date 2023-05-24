package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.UserDAO;

@Controller
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String UserIndex(Model model) {

       model.addAttribute("users", userDAO.index());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String showUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("human",userDAO.show(id));
        return "show";
    }
}
