package com.yumamur.firstweb;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, UUID> usernameMap = new HashMap<>();
    private final Map<UUID, User> uuidMap = new HashMap<>();
    protected final Count count = new Count();
    public boolean containsUser(String name) {
        return usernameMap.containsKey(name);
    }
    public User getUser(String name) {
        return uuidMap.get(usernameMap.get(name));
    }
    public void saveUser(User user) {
            uuidMap.put(usernameMap.get(user.getName()), user);
    }
    protected class Count {
        public long user() {
            return uuidMap.size();
        }
    }
    public List<User> getAll() {
        return uuidMap.values().stream().toList();
    }
    public boolean addUser(User user) {
        if (usernameMap.containsKey(user.getName())) {
            return false;
        } else {
            usernameMap.put(user.getName(), UUID.randomUUID());
            uuidMap.put(usernameMap.get(user.getName()), user);
            return true;
        }
    }
}
