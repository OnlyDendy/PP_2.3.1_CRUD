package web.dao;

import web.models.Users;

import java.util.List;

public interface UserDao {

    List<Users> index(); //Показать всех

    Users show(long id); // Показать каждого по указателю лкм

    void save(Users users); // создать нового

    void update(long id, Users updateUsers); // редактировать человека

    void delete(long id); // удалить
}
