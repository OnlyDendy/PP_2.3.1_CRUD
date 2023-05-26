package web.dao;

import web.models.Users;

import java.util.List;

public interface UserDao {

    public List<Users> index(); //Показать всех

    public Users show(long id); // Показать каждого по указателю лкм

    public void save(Users users); // создать нового

    public void update(long id,Users updateUsers); // редактировать человека
    public void delete(long id); // удалить
}
