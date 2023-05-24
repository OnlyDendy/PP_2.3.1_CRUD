package web.service;

import org.springframework.stereotype.Component;
import web.models.Users;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static long USERS_COUNT;
    private final List<Users> users;

    {
        users = new ArrayList<>();
        users.add(new Users(++USERS_COUNT, "Anton", "Shorin", 31, "Ant123@gmail.com", "12345", "Создатель"));
        users.add(new Users(++USERS_COUNT, "Olga", "Shorina", 31, "Olga123@gmail.com", "54321", "Зам"));
        users.add(new Users(++USERS_COUNT, "Елена", "Калашникова", 33, "Elena123@gmail.com", "123321", "Сестра жены"));
        users.add(new Users(++USERS_COUNT, "Максим", "Калашников", 31, "Maks123@gmail.com", "77722", "Муж сестры"));
    }

    public List<Users> index(){
        return users;
    }
    public Users show(long id) {
        return users.stream().filter(users1 -> users1.getId() == id).findAny().orElse(null);
    }
}
