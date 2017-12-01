package com.storeApp.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import com.storeApp.entities.users.User;
import com.storeApp.models.bindingModels.CreateUserModel;
import com.storeApp.models.bindingModels.LogInModel;
import com.storeApp.models.viewModels.ItemViewModel;
import com.storeApp.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Stateless
@Controller
public class UserController {

    @Inject
    private UserService userService;





    @GetMapping("/login")
    public String getLogInPage() {
        return "/templates/login";
    }

    @PostMapping("/login")
    public String logInUser(@ModelAttribute LogInModel loginModel, Model model, HttpSession session) {
        User user = this.userService.findLoggedInUser(loginModel);
        if (user == null) {
            model.addAttribute("loginError", "loginError");
            return "/templates/login";
        }

        session.setAttribute("currentUser", user);

        return "redirect:/";
    }

    @GetMapping("/create")
    public String getCreateUserPage() {
        return "/templates/create-user";
    }

    @PostMapping("/create")
    public String registerUser(@ModelAttribute CreateUserModel createUserModel, Model model) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<CreateUserModel>> constraintViolations = validator.validate(createUserModel);
        if (constraintViolations.size() > 0) {
            model.addAttribute("constraintViolations", constraintViolations);
            return "/templates/create-user";
        }

        if (!createUserModel.getPassword().equals(createUserModel.getRepeatPassword())) {
            model.addAttribute("passwordMismatch", "passwordMismatch");
            return "/templates/create-user";
        }

        this.userService.registerUser(createUserModel);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
