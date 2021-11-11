package org.duongnhieu.filter;

import org.duongnhieu.constant.SystemConstant;
import org.duongnhieu.models.UserModel;
import org.duongnhieu.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        UserModel userModel = (UserModel) SessionUtil.getSessionUtil().getValue(request, "USER");
        if (url.startsWith("/ServletApi_war/admin")) {
            if (userModel != null) {
                if (userModel.getRoleModel().getCode().equals(SystemConstant.USER)) {
                    response.sendRedirect("/trang-chu");
                } else if (userModel.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
                    response.sendRedirect("/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("URL " + url);
    }

    @Override
    public void destroy() {

    }
}
