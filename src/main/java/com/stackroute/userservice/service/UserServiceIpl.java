package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceIpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
// two objects depends on each other then go for setter injection
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User saveUser(User user)
    {
        User savedUser=userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User Update(User user,int id) {
        User userToBeUpdated=userRepository.findById(id).get();
        userToBeUpdated.setAge(user.getAge());
        return userRepository.save(userToBeUpdated);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
