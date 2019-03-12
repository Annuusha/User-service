package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUser();
    public User Update(User user,int id);
    public Optional<User> getById(int id);
    public void deleteUser(int id);
}
