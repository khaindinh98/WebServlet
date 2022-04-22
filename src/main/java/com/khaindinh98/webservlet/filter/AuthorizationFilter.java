package com.khaindinh98.webservlet.filter;

import com.khaindinh98.webservlet.model.RoleModel;
import com.khaindinh98.webservlet.model.UserModel;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter{

    private final static Logger logger = Logger.getLogger(AuthorizationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        String requestURI = req.getServletPath();
        if(requestURI.contains("/admin")) {
            if(userModel!=null && userModel.getRoleCode().equals(RoleModel.ADMIN_ROLE)){
                chain.doFilter(request, response);
            }else{
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
