package org.duongnhieu.controllers.web;

import org.duongnhieu.constant.SystemConstant;
import org.duongnhieu.models.CategoryModel;
import org.duongnhieu.models.UserModel;
import org.duongnhieu.services.iCategoryService;
import org.duongnhieu.services.iUserService;
import org.duongnhieu.utils.FormUtil;
import org.duongnhieu.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/login", "/thoat"})
public class HomeController extends HttpServlet {
    @Inject
    private iCategoryService iCategory;
    @Inject
    private CategoryModel categoryModel;
    @Inject
    private iUserService iUserService;

//    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/trang-chu" : {
                request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
                break;
            }
            case "/dang-nhap" : {
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                break;
            }
            case "/login" : {
                login(request, response);
                break;
            }
            case "/thoat" : {
                SessionUtil.getSessionUtil().removeValue(request, "USER");
                response.sendRedirect(request.getContextPath() + "/dang-nhap");
                break;
            }
            default:
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel userModel = FormUtil.toClass(UserModel.class, request);
        userModel = iUserService.findByUsernameAndPasswordAndStatus(
                userModel.getUsername(), userModel.getPassword(), 1
        );
        if (userModel != null) {
            SessionUtil.getSessionUtil().putValue(request, "USER", userModel);
            if (userModel.getRoleModel().getCode().equals(SystemConstant.USER)) {
                response.sendRedirect(request.getContextPath() + "/trang-chu");
            } else if (userModel.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
                response.sendRedirect(request.getContextPath() + "/admin-home");
            }
        } else {
//            String alert = request.getParameter("alert");
//            String message = request.getParameter("message");
//            request.setAttribute("message", resourceBundle.getString("message_login_fail"));
//            request.setAttribute("alert", alert);
            response.sendRedirect(request.getContextPath() + "/dang-nhap");
        }
    }
}
