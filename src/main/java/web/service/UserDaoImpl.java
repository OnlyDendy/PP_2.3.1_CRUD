package web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.Users;

import java.util.List;


@Component
public class UserDaoImpl  implements UserDao{

    private final UserDao userDao;

    public UserDaoImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<Users> index() {
        return null;
    }

    @Override
    public Users show(long id) {
        return null;
    }
    @Transactional
    @Override
    public void save(Users users) {

    }
    @Transactional
    @Override
    public void update(int id, Users updateUsers) {

    }

    @Transactional
    @Override
    public void delete(int id) {

    }
}
