package com.yumamur.firstapidb;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private static final String PASSWD = "123456qwe";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(User user) {
        for (User find : userRepository.findAll()) {
            if (find.getName().equalsIgnoreCase(user.getName())) {
                return "Failure";
            }
        }
        userRepository.save(user);
        return "Successful";
    }
    public String clearRepository(Integer id, UserDeleteRequest key) {
        if (PASSWD.equals(key.getKey()))
        {
            userRepository.deleteById(id);
            return "Successful";
        }
        return "Who are you?";
    }
}