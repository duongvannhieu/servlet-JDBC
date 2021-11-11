package org.duongnhieu.services;

import org.duongnhieu.models.UserModel;

public interface iUserService {
    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
