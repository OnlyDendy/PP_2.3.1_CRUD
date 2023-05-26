package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.Users;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Users> index() {
        return userDao.index();
    }

    @Override
    public Users show(long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void save(Users users) {
        userDao.save(users);
    }

    @Transactional
    @Override
    public void update(long id,Users updateUsers) {
        userDao.update(id,updateUsers);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
