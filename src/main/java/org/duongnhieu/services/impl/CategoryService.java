package org.duongnhieu.services.impl;

import org.duongnhieu.dao.imp.CategoryDao;
import org.duongnhieu.models.CategoryModel;
import org.duongnhieu.services.iCategoryService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class CategoryService implements iCategoryService{
    @Inject
    private CategoryDao categoryDao;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        categoryModel.setCreateddate(new Timestamp(System.currentTimeMillis()));
        categoryModel.setCreatedby("");
        Long id = categoryDao.insert(categoryModel);
        return categoryDao.findOne(id);
    }

    @Override
    public CategoryModel update(CategoryModel updateModel) {
        CategoryModel oldCategory = categoryDao.findOne(updateModel.getId());
        updateModel.setCreateddate(oldCategory.getCreateddate());
        updateModel.setCreatedby(oldCategory.getCreatedby());
        updateModel.setModifieddate(new Timestamp(System.currentTimeMillis()));
        updateModel.setModifiedby("");
        categoryDao.update(updateModel);
        return categoryDao.findOne(updateModel.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids) {
            categoryDao.delete(id);
        }
    }
}
