package com.storeApp.serviceImpl;

import com.storeApp.entities.users.Role;
import com.storeApp.entities.users.User;
import com.storeApp.models.bindingModels.CreateUserModel;
import com.storeApp.models.bindingModels.LogInModel;
import com.storeApp.repositories.UserRepository;
import com.storeApp.services.UserService;
import com.storeApp.utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void registerUser(CreateUserModel createUserModel) {
        User user = modelParser.convert(createUserModel, User.class);
        Role defaultRole = Role.USER;
        user.setRole(defaultRole);
        this.userRepository.save(user);
    }

    @Override
    public User findLoggedInUser(LogInModel logInModel) {
        User user = this.userRepository.findByUsernameAndPassword(logInModel.getUsername(), logInModel.getPassword());
        return user;
    }
}
