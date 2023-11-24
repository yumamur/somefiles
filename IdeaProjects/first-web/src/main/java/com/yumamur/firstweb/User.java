package com.yumamur.firstweb;

import java.util.List;
import java.util.StringJoiner;

public class User {
    private final String name;
    private List<String> roles;

    public User(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }
    public String getName() {
        return name;
    }
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    public String infoString() {
        return "Username =\t" + name + "\nRoles    =\t" + String.join(", ", roles);
    }
}
