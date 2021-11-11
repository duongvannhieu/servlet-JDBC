package org.duongnhieu.mapper;

import java.sql.ResultSet;

public interface iRowMapper<T> {
    T mapRow(ResultSet rs);
}
