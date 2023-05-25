package web.service;

import org.springframework.stereotype.Component;
import web.models.Users;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl  {
    private static long USERS_COUNT;
    private final List<Users> usersList;

    {
        usersList = new ArrayList<>();

        usersList.add(new Users(++USERS_COUNT, "Anton", "Shorin", 31, "Ant123@gmail.com", "12345", "Создатель"));
        usersList.add(new Users(++USERS_COUNT, "Olga", "Shorina", 31, "Olga123@gmail.com", "54321", "Зам"));
        usersList.add(new Users(++USERS_COUNT, "Елена", "Калашникова", 33, "Elena123@gmail.com", "123321", "Сестра жены"));
        usersList.add(new Users(++USERS_COUNT, "Максим", "Калашников", 35, "Maks123@gmail.com", "77722", "Муж сестры"));
    }

    public List<Users> index() {
        return usersList;
    }

    public Users show(long id) {
        return usersList.stream().filter(users1 -> users1.getId() == id).findAny().orElse(null);
    }

    public void save(Users users) {
        users.setId(++USERS_COUNT);
        usersList.add(users);
    }

    public void update(int id, Users updateUsers) {
        Users usersToBeUpdated = show(id);

        usersToBeUpdated.setName(updateUsers.getName());
        usersToBeUpdated.setLastname(updateUsers.getLastname());
        usersToBeUpdated.setAge(updateUsers.getAge());
        usersToBeUpdated.setEmail(updateUsers.getEmail());
        usersToBeUpdated.setPassword(updateUsers.getPassword());
        usersToBeUpdated.setRoles(updateUsers.getRoles());

    }

    public void delete(int id) {
        usersList.removeIf(users -> users.getId() == id);
    }
}
