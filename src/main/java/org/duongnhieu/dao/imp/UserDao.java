package org.duongnhieu.dao.imp;

import org.duongnhieu.dao.iUserDao;
import org.duongnhieu.mapper.NewMapper;
import org.duongnhieu.mapper.UserMapper;
import org.duongnhieu.models.NewModel;
import org.duongnhieu.models.UserModel;

import java.util.List;

public class UserDao extends AbstractDao<UserModel> implements iUserDao{

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
        StringBuilder sqlCommand = new StringBuilder("SELECT * FROM users AS user ");
        sqlCommand.append("INNER JOIN roles AS role ON role.id = user.role_id ");
        sqlCommand.append("WHERE username=? AND password=? AND status=?");
        List<UserModel> userModel = query(sqlCommand.toString(), new UserMapper(), username, password, status);
        return userModel.isEmpty() ? null : userModel.get(0);
    }
}
