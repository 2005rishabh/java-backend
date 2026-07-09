package com.example.lecture13.service;

import java.util.HashMap;
import java.util.Map;

import com.example.lecture13.model.User;

public class UserService {
    private Map<Integer, User> map;

    public UserService() {
        map = new HashMap<>();
    }

    public User createUser(User reqUser) {
        map.put(reqUser.getId(), reqUser);
        return reqUser;
    }

}
