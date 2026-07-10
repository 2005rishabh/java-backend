package com.example.lecture13.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public User getUserById(Integer id) {
        return map.getOrDefault(id, null);
    }

    public List<User> getUsers() {
        // Corrected: You cannot cast a Map Collection directly to a List.
        return new ArrayList<>(map.values());
    }

    public User updateUser(Integer id, User userReq) {
        if (map.containsKey(id)) {
            map.put(id, userReq);
            return userReq;
        }
        return null;
    }

    public String deleteUser(Integer id) { // Corrected spelling
        if (map.remove(id) != null) {
            return "User deleted successfully";
        }
        return "User not found";
    }
}