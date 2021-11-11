package org.duongnhieu.dao.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.duongnhieu.dao.iGenericDao;
import org.duongnhieu.mapper.iRowMapper;
import org.duongnhieu.models.NewModel;

public class AbstractDao<T> implements iGenericDao<T> {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    public Connection getConnection() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/servletapi?useUnicode=true&characterEncoding=utf-8";
//            String user = "root";
//            String password = "";
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Get connection error " + e.getMessage());
            return null;
        }
    }

    public void setParameters(PreparedStatement preparedStatement, Object... parameters) {
        for (int i = 0; i < parameters.length; i++) {
            Object parameter = parameters[i];
            int index = i + 1;
            try {
                if (parameter instanceof Long) {
                    preparedStatement.setLong(index, (Long) parameter);
                } else if (parameter instanceof  String) {
                    preparedStatement.setString(index, (String) parameter);
                } else if (parameter instanceof Timestamp) {
                    preparedStatement.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) parameter);
                }
            } catch (SQLException e) {
                System.out.println("Set parameters error " + e.getMessage());
            }
        }
    }

    @Override
    public <T> List<T> query(String sqlCommand, iRowMapper<T> rowMapper, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sqlCommand);
            setParameters(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(rowMapper.mapRow(resultSet));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("List error " + e.getMessage());
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e1) {
                System.out.println("Close list error " + e1.getMessage());
            }
        }
    }

    @Override
    public Long save(String sqlCommand, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long id = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlCommand, Statement.RETURN_GENERATED_KEYS);
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet != null && resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            System.out.println("Save error " + e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e1) {
                System.out.println("Close get by id error " + e1.getMessage());
            }
        }
    }

    @Override
    public void update(String sqlCommand, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlCommand);
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Update error " + e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e1) {
                System.out.println("Update close error " + e1.getMessage());
            }
        }
    }
}
