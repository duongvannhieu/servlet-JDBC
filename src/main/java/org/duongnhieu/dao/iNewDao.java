package org.duongnhieu.dao;

import org.duongnhieu.models.NewModel;

import java.util.List;

public interface iNewDao extends iGenericDao<NewModel>{
    List<NewModel> findAll();
    NewModel findOne(Long id);
    Long insert(NewModel newModel);
    void update(NewModel newModel);
    void delete(Long id);
}
