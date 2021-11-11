package org.duongnhieu.services.impl;

import org.duongnhieu.models.UserModel;
import org.duongnhieu.services.iUserService;
import org.duongnhieu.dao.iUserDao;

import javax.inject.Inject;

public class UserService implements iUserService{
    @Inject
    private iUserDao iUserDao;

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
        return iUserDao.findByUsernameAndPasswordAndStatus(username, password, status);
    }
}
