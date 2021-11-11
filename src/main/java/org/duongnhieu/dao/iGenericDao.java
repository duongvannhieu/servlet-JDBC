package org.duongnhieu.dao;

import java.util.List;

import org.duongnhieu.mapper.iRowMapper;

public interface iGenericDao<T> {
    <T> List<T> query(String sqlCommand, iRowMapper<T> rowMapper, Object... parameters);
    Long save(String sqlCommand, Object... parameters);
    void update(String sqlCommand, Object... parameters);
}
