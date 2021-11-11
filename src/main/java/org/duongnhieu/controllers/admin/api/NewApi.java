package org.duongnhieu.controllers.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.duongnhieu.models.NewModel;
import org.duongnhieu.models.UserModel;
import org.duongnhieu.utils.HttpUtil;
import org.duongnhieu.utils.SessionUtil;
import org.duongnhieu.services.*;
import org.duongnhieu.services.impl.*;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewApi extends HttpServlet {
    @Inject
    private iNewService iNewService;
    @Inject
    private NewService newService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
        newModel.setCreatedby(((UserModel) SessionUtil.getSessionUtil().getValue(request, "USER")).getUsername());
        newModel = newService.save(newModel);
        objectMapper.writeValue(response.getOutputStream(), newModel);
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        NewModel updateModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
//        updateModel.setModifiedby(((UserModel) SessionUtil.getSessionUtil().getValue(request, "USER")).getUsername());
        updateModel = iNewService.update(updateModel);
        objectMapper.writeValue(response.getOutputStream(), updateModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        NewModel deleteModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        iNewService.delete(deleteModel.getIds());
        objectMapper.writeValue(resp.getOutputStream(), "Delete Complete");
    }
}
