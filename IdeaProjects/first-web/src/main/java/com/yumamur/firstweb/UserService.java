package com.yumamur.firstweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    public static final int SUCCESS = 0x00;
    public static final int EXISTING_USER = 0x01;
    public static final int NON_EXISTING_USER = 0x02;
    public static final int INVALID_CREDENTIALS = 0x03;
    public static final int REPOSITORY_ERROR = 0x04;
    private static final int FAILURE = 0xff;

    @Autowired
    private UserRepository userRepository;
    public int updateUser(String username, User userDetails) {
        if (userRepository.containsUser(userDetails.getName()))
            return EXISTING_USER;
        else if (userRepository.containsUser(username)) {
            userRepository.getUser(username).setRoles(userDetails.getRoles());
            return SUCCESS;
        } else {
            return NON_EXISTING_USER;
        }
    }
    public int addUser(User userDetails) {
        if (!userRepository.containsUser(userDetails.getName())) {
            try {
                if (userRepository.addUser(userDetails))
                    return SUCCESS;
                else
                    return FAILURE;
            } catch (Exception e) {
                return REPOSITORY_ERROR;
            }
        } else {
            return EXISTING_USER;
        }
    }
    public String getAll() {
        if (userRepository.count.user() == 0)
            return "Repository is empty";
        List<String> ret = new ArrayList<>();
        for (User user : userRepository.getAll()) {
            ret.add(user.infoString());
        }
        return String.join("\n\n@@@@@@@@@@@\n\n", ret);
    }
    public User getByUsername(String username) {
        return userRepository.getUser(username);
    }
}