
package com.example.springboot.dao;

import com.example.springboot.model.Users;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class DAOImpl implements DAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("select u from Users u", Users.class).getResultList();
    }

    @Override
    public void addUser(Users users) {
        entityManager.persist(users);
    }

    @Override
    public void updateUser(Users users) {
        entityManager.merge(users);
    }

    @Override
    public Users removeUser(long id) {
        Users users = entityManager.find(Users.class, id);
        entityManager.remove(users);
        return users;
    }

    @Override
    public Users getUserId(long id) {
        TypedQuery<Users> query = entityManager.createQuery("select u from Users u where u.id =:users_id", Users.class);
        query.setParameter("users_id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
