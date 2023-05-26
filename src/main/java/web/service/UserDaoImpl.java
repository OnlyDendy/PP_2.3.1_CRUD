package web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Users> index() {
        return entityManager.createQuery("FROM Users", Users.class).getResultList();//
    }

    @Override
    public Users show(long id) {
        return entityManager.find(Users.class, id);//
    }

    @Transactional
    @Override
    public void save(Users users) {
        entityManager.persist(users);//
    }

    @Transactional
    @Override
    public void update(int id, Users updateUsers) {//
        entityManager.merge(updateUsers);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Users users = entityManager.find(Users.class,id);//
        entityManager.remove(users);
    }
}
