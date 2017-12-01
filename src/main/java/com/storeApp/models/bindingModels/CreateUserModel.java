package com.storeApp.models.bindingModels;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUserModel {

    @Size(min = 5, max = 30, message = "The username should be between 5 and 30 symbols")
    private String username;

    @Size(min = 5, message = "The full name should be at least 5 symbols")
    private String fullName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*,.])[A-Za-z\\d!@#$%^&*,.]{8,}$", message = "The password should contain a capital letter, a number and a sign [!@#$%^&*,.]")
    private String password;

    private String repeatPassword;

    public CreateUserModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
