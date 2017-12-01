package com.storeApp.repositories;

import com.storeApp.entities.users.User;

public interface UserRepository {

    void save(User user);

    User findByUsernameAndPassword(String username, String password);
}