package com.storeApp.services;

import com.storeApp.entities.users.User;
import com.storeApp.models.bindingModels.CreateUserModel;
import com.storeApp.models.bindingModels.LogInModel;

public interface UserService {

    void registerUser(CreateUserModel createUserModel);

    User findLoggedInUser(LogInModel logInModel);
}
