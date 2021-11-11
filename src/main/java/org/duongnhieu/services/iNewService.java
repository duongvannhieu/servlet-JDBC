package org.duongnhieu.services;

import org.duongnhieu.models.NewModel;

import java.util.List;

public interface iNewService {
    List<NewModel> findAll();
    NewModel save(NewModel newModel);
    NewModel update(NewModel newModel);
    NewModel findById(Long id);
    void delete(Long[] ids);
}
