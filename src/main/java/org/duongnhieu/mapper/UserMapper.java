package org.duongnhieu.mapper;

import org.duongnhieu.models.RoleModel;
import org.duongnhieu.models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements iRowMapper<UserModel>{
    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel userModel = new UserModel();
        RoleModel roleModel = new RoleModel();
        try {
            userModel.setId(rs.getLong("id"));
            userModel.setUsername(rs.getString("username"));
            userModel.setPassword(rs.getString("password"));
            userModel.setFullname(rs.getString("fullname"));
            userModel.setStatus(rs.getInt("status"));

            try {
                roleModel.setCode(rs.getString("code"));
                roleModel.setName(rs.getString("name"));
            } catch (Exception e) {
                System.out.println("User mapper user error " + e.getMessage());
            }
            userModel.setRoleModel(roleModel);
            return userModel;
        } catch (SQLException e) {
            System.out.println("User mapper error " + e.getMessage());
            return null;
        }
    }
}
