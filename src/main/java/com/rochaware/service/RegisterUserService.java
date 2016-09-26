package com.rochaware.service;

import com.rochaware.exception.ServiceException;
import com.rochaware.model.User;

/**
 * Created by hdlopesrocha on 26-09-2016.
 */
public class RegisterUserService extends Service<User> {


    private String email;
    private String name;
    private String password;

    public RegisterUserService(String email, String name, String password){
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @Override
    public User dispatch() throws ServiceException {
        User user = new User(email,name,password);
        user.save();
        return user;
    }

    @Override
    public boolean canExecute() {
        return true;
    }
}
