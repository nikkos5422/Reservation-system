package com.football.auth.service;

import com.football.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
