package org.duongnhieu.mapper;

import org.duongnhieu.models.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements iRowMapper{
    @Override
    public Object mapRow(ResultSet rs) {
        NewModel newModel = new NewModel();
        try {
            newModel.setId(rs.getLong("id"));
            newModel.setCategoryId(rs.getLong("category_id"));
            newModel.setTitle(rs.getString("title"));
            newModel.setShortDescription(rs.getString("short_description"));
            newModel.setThumbmail(rs.getString("thumbmail"));
            newModel.setContent(rs.getString("content"));
            newModel.setCreateddate(rs.getTimestamp("createddate"));
            newModel.setModifieddate(rs.getTimestamp("modifieddate"));
            newModel.setCreatedby(rs.getString("createdby"));
            newModel.setModifiedby(rs.getString("modifiedby"));
            return newModel;
        } catch (SQLException e) {
            System.out.println("Mapper new error " + e.getMessage());
            return null;
        }
    }
}
