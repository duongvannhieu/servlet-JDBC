package org.duongnhieu.controllers.admin;

import org.duongnhieu.constant.SystemConstant;
import org.duongnhieu.models.NewModel;
import org.duongnhieu.models.UserModel;
import org.duongnhieu.services.*;
import org.duongnhieu.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Timestamp;

@WebServlet(urlPatterns = {"/admin-new", "/admin-new-edit", "/admin-new-update", "/admin-new-add", "/admin-new-insert",
                            "/admin-new-delete"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class NewController extends HttpServlet {
    @Inject
    private iNewService iNewService;
    @Inject
    private NewModel newModel;
    @Inject
    private iCategoryService iCategoryService;

    private static final String UPLOAD_DIR = "template\\admin\\assets\\img";

    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/admin-new" : {
                NewModel newModel = new NewModel();
                newModel.setListResult(iNewService.findAll());
//                getFolderUpload(request);
                request.setAttribute(SystemConstant.NEW, newModel);
                request.getRequestDispatcher("/views/admin/new/list.jsp").forward(request, response);
                break;
            }
            case "/admin-new-edit" : {
                getById(request, response);
                break;
            }
            case "/admin-new-add" : {
                request.getRequestDispatcher("/views/admin/new/list-add.jsp").forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("categories", iCategoryService.findAll());
        request.setAttribute(SystemConstant.EDIT_NEW, iNewService.findById(Long.valueOf(id)));
        request.getRequestDispatcher("/views/admin/new/list-edit.jsp").forward(request, response);
    }
}
