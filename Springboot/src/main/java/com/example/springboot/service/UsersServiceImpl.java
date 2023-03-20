package com.example.springboot.service;

import com.example.springboot.dao.DAO;
import com.example.springboot.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class UsersServiceImpl implements UsersService{
    private final DAO userDAO;

    @Autowired
    public UsersServiceImpl(DAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public Users getUserId(long id) {
        return userDAO.getUserId(id);
    }

    @Override
    @Transactional
    public void addUser(Users user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Users user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public Users removeUser(long id) {
        return userDAO.removeUser(id); }
}
