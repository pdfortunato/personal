package com.personal.project.firstday.service;

import com.personal.project.firstday.model.User;

import java.util.List;

public class UserService {

    //filtro users attivi e restituisco lista di nomi unici (senza duplicati)
    public List<String> getActiveUsers(List<User> users) {
        return users.stream()
                .filter(User::isActive)
                .map(User::getName)
                .distinct()
                .sorted()
                .toList();
    }
}
