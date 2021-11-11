package org.duongnhieu.controllers.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.duongnhieu.models.CategoryModel;
import org.duongnhieu.models.UserModel;
import org.duongnhieu.services.impl.CategoryService;
import org.duongnhieu.utils.HttpUtil;
import org.duongnhieu.services.iCategoryService;
import org.duongnhieu.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(urlPatterns = {"/api-admin-category"})
public class CategoryApi extends HttpServlet {
    @Inject
    private iCategoryService iCategoryService;
    @Inject
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryModel categoryModel = HttpUtil.of(request.getReader()).toModel(CategoryModel.class);
        categoryModel.setCreatedby(((UserModel) SessionUtil.getSessionUtil().getValue(request,"USER")).getUsername());
        categoryModel = categoryService.save(categoryModel);
        objectMapper.writeValue(response.getOutputStream(), categoryModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryModel updateModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
        updateModel.setModifiedby(((UserModel) SessionUtil.getSessionUtil().getValue(req, "USER")).getUsername());
        updateModel = iCategoryService.update(updateModel);
        objectMapper.writeValue(resp.getOutputStream(), updateModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryModel deleteModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
        iCategoryService.delete(deleteModel.getIds());
        objectMapper.writeValue(resp.getOutputStream(), "Delete Complete");
    }
}
