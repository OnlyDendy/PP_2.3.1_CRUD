package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Users> index() {
        return entityManager.createQuery("FROM Users", Users.class).getResultList();
    }

    @Override
    public Users show(long id) {
        return entityManager.find(Users.class, id);
    }


    @Override
    public void save(Users users) {
        entityManager.persist(users);
    }


    @Override
    public void update(long id,Users updateUsers) {
        entityManager.merge(updateUsers);
        entityManager.flush();
    }

    @Override
    public void delete(long id) {
        Users users = entityManager.find(Users.class,id);
        entityManager.remove(users);
    }
}
