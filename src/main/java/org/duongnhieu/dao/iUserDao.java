package org.duongnhieu.dao;

import org.duongnhieu.models.UserModel;

public interface iUserDao extends iGenericDao<UserModel>{
    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
