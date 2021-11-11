package org.duongnhieu.dao.imp;

import org.duongnhieu.dao.iNewDao;
import org.duongnhieu.mapper.NewMapper;
import org.duongnhieu.models.NewModel;

import java.util.List;

public class NewDao extends AbstractDao<NewModel> implements iNewDao{
    @Override
    public List<NewModel> findAll() {
        String sqlCommand = "select * from news";
        return query(sqlCommand, new NewMapper());
    }

    @Override
    public NewModel findOne(Long id) {
        String sqlCommand = "select * from news where id=?";
        List<NewModel> newModelList = query(sqlCommand, new NewMapper(), id);
        return newModelList.isEmpty() ? null : newModelList.get(0);
    }

    @Override
    public Long insert(NewModel newModel) {
        String sqlCommand = "insert into news (category_id, title, short_description, thumbmail, content, createddate, createdby) " +
                "value (?, ?, ?, ?, ?, ?, ?)";
        return save(sqlCommand, newModel.getCategoryId(), newModel.getTitle(), newModel.getShortDescription(),
                newModel.getThumbmail(), newModel.getContent(), newModel.getCreateddate(), newModel.getCreatedby());
    }

    @Override
    public void update(NewModel newModel) {
        String sqlCommand = "update news set category_id=?, title=?, short_description=?, thumbmail=?, content=?," +
                " createddate=?, modifieddate=?, createdby=?, modifiedby=? where id=?";
        update(sqlCommand, newModel.getCategoryId(), newModel.getTitle(), newModel.getShortDescription(),
                newModel.getThumbmail(), newModel.getContent(),
                newModel.getCreateddate(), newModel.getModifieddate(), newModel.getCreatedby(), newModel.getModifiedby(),
                newModel.getId());
    }

//    @Override
//    public NewModel findById(Long id) {
//        String sqlCommand = "select * from news where id=?";
//        return query(sqlCommand, id);
//    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "delete from news where id=?";
        update(sqlCommand, id);
    }
}
