package org.duongnhieu.services;

import org.duongnhieu.models.CategoryModel;

import java.util.List;

public interface iCategoryService {
    List<CategoryModel> findAll();
    CategoryModel save(CategoryModel categoryModel);
    CategoryModel update(CategoryModel updateModel);
    void delete(Long[] ids);
}
