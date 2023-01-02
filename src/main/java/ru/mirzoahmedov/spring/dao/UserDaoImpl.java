package ru.mirzoahmedov.spring.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.mirzoahmedov.spring.model.UserEntity;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserEntity> getAllUser() {
        return entityManager.createQuery("select u from UserEntity u", UserEntity.class)
                .getResultList();
    }

    @Override
    public void save(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public UserEntity show(Long id) {
        Query query = entityManager.createQuery("from UserEntity where id = : number");
        query.setParameter("number", id);
        return (UserEntity) query.getResultList().get(0);
    }

    @Override
    public void update(Long id, UserEntity userEntity) {
        UserEntity userToUpdate = show(id);
        userToUpdate.setId(userEntity.getId());
        userToUpdate.setName(userEntity.getName());
        userToUpdate.setSurname(userEntity.getSurname());
        userToUpdate.setAge(userEntity.getAge());
        save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(show(id));
    }
}
