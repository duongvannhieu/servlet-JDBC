package org.duongnhieu.dao;

import org.duongnhieu.models.CategoryModel;

import java.util.List;

public interface iCategoryDao extends iGenericDao<CategoryModel>{
    List<CategoryModel> findAll();
    CategoryModel findOne(Long id);
    Long insert(CategoryModel categoryModel);
    void update(CategoryModel updateModel);
    void delete(Long id);
    CategoryModel findByCode(String code);
}
