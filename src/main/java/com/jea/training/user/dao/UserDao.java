package com.jea.training.user.dao;

import com.jea.training.user.model.User;

public interface UserDao
{
    String signUp (User user);
    User logIn (String username, String password);

}
