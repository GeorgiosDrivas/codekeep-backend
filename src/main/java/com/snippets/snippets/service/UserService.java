package com.snippets.snippets.service;

import com.snippets.snippets.model.User;
import com.snippets.snippets.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    };

    public User getUser(Long id){
        Optional<User> optional = userRepository.findById(id);
        return optional.get();
    };

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    };

    public boolean isUserExist(Long id){
        return userRepository.existsById(id);
    };

    public User getUserByUsernameAndPassword(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
        return userOptional.orElse(null);
    }
}
