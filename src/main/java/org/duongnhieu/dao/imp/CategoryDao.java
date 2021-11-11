package org.duongnhieu.dao.imp;

import org.duongnhieu.mapper.CategoryMapper;
import org.duongnhieu.mapper.NewMapper;
import org.duongnhieu.models.CategoryModel;
import org.duongnhieu.dao.iCategoryDao;
import org.duongnhieu.models.NewModel;

//import javax.inject.Inject;
import java.util.List;

public class CategoryDao extends AbstractDao<CategoryModel> implements iCategoryDao{

    @Override
    public List<CategoryModel> findAll() {
        String sqlCommand = "select * from categories";
        return query(sqlCommand, new CategoryMapper());
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sqlCommand = "select * from categories where id=?";
        List<CategoryModel> categoryModelList = query(sqlCommand, new CategoryMapper(), id);
        return categoryModelList.isEmpty() ? null : categoryModelList.get(0);
    }

    @Override
    public Long insert(CategoryModel categoryModel) {
        String sqlCommand = "insert into categories (name, code, createddate, createdby) values (?, ?, ?, ?)";
        return save(sqlCommand, categoryModel.getName(), categoryModel.getCode(),
                categoryModel.getCreateddate(), categoryModel.getCreatedby());
    }

    @Override
    public void update(CategoryModel updateModel) {
        String sqlCommand = "update categories set name=?, code=?, createddate=?, modifieddate=?," +
                "createdby=?, modifiedby=? where id=?";
        update(sqlCommand, updateModel.getName(), updateModel.getCode(), updateModel.getCreateddate(), updateModel.getModifieddate(),
                updateModel.getCreatedby(), updateModel.getModifiedby(),
                updateModel.getId());
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "delete from categories where id=?";
        update(sqlCommand, id);
    }

    @Override
    public CategoryModel findByCode(String code) {
        String sqlCommand = "select * from categories where code=?";
        List<CategoryModel> categoryModelList = query(sqlCommand, new NewMapper(), code);
        return categoryModelList.isEmpty() ? null : categoryModelList.get(0);
    }
}
