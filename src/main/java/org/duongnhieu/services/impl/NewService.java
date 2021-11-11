package org.duongnhieu.services.impl;

import org.duongnhieu.dao.*;
import org.duongnhieu.dao.imp.*;
import org.duongnhieu.models.*;
import org.duongnhieu.services.iNewService;
import org.duongnhieu.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements iNewService{
    @Inject
    private NewDao newDao;
    @Inject
    private iCategoryDao iCategoryDao;
    @Inject
    private CategoryDao categoryDao;

    private HttpServletRequest request;
    @Override
    public List<NewModel> findAll() {
        return newDao.findAll();
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreateddate(new Timestamp(System.currentTimeMillis()));
        newModel.setCreatedby("");
//        CategoryModel categoryModel = categoryDao.findByCode(newModel.getCategoryCode());
//        newModel.setCategoryId(categoryModel.getId());
        Long id = newDao.insert(newModel);
        return newDao.findOne(id);
    }

    @Override
    public NewModel update(NewModel updateModel) {
        NewModel oldNew = newDao.findOne(updateModel.getId());
        updateModel.setCreateddate(oldNew.getCreateddate());
        updateModel.setCreatedby(oldNew.getCreatedby());
        updateModel.setModifieddate(new Timestamp(System.currentTimeMillis()));
//        CategoryModel categoryModel = categoryDao.findByCode(updateModel.getCategoryCode());
//        updateModel.setCategoryId(categoryModel.getId());
        newDao.update(updateModel);
        return newDao.findOne(updateModel.getId());
    }

    @Override
    public NewModel findById(Long id) {
        NewModel newModel = newDao.findOne(id);
        CategoryModel categoryModel = iCategoryDao.findOne(newModel.getCategoryId());
        newModel.setCategoryCode(categoryModel.getCode());
        return newModel;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids) {
            newDao.delete(id);
        }
    }
}
