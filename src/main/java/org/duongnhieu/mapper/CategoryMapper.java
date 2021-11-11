package org.duongnhieu.mapper;

import org.duongnhieu.models.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements  iRowMapper<CategoryModel>{
    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel.setId(rs.getLong("id"));
            categoryModel.setName(rs.getString("name"));
            categoryModel.setCode(rs.getString("code"));
            categoryModel.setCreateddate(rs.getTimestamp("createddate"));
            categoryModel.setModifieddate(rs.getTimestamp("modifieddate"));
            categoryModel.setCreatedby(rs.getString("createdby"));
            categoryModel.setModifiedby(rs.getString("modifiedby"));
            return categoryModel;
        } catch (SQLException e) {
            System.out.println("Category mapper error " + e.getMessage());
            return null;
        }
    }
}
