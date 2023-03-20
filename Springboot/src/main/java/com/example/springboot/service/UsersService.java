package com.example.springboot.service;

import com.example.springboot.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> getAllUsers();

    Users getUserId(long id);

    void addUser(Users users);

    void updateUser(Users users);

    Users removeUser(long id);
}
