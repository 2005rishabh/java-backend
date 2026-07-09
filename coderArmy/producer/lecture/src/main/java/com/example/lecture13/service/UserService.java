package com.example.lecture13.service;

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
        return (List<User>) map.values();
    }

    public User updateUser(Integer id, User userReq) {
        map.put(id, userReq);
        return userReq;
    }

    public String deletUser(Integer id) {
        map.remove(id);
        return "User deleted successfully";
    }



}
