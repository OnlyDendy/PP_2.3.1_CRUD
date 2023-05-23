package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @GetMapping(value = "/users")
    public String UserHello(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Привет!");
        messages.add("Наконец то заработало!");
        messages.add("22:54, грёбаный вторник! ");
        model.addAttribute("users", messages);
        return "users";
    }
}
