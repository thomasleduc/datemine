package com.epita.mti.datemine.web.filter;

import com.epita.mti.datemine.web.auth.Auth;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leduc_t
 */
public class LoginFilter implements Filter  {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        Auth session = (Auth) req.getSession().getAttribute("auth");
        String url = req.getRequestURI();
        /*
        A. if request is for main or logout and there's no session, redirect the request to login.xhtml
        B. if request is for register or login and there's a session, redirect the request to main.xhtml
        C. if request is for logout and there's a session, remove the session, then redirect to login.xhtml
        */
        
        if (session == null) {
            System.out.println("Auth null ...");
        } else {
            System.out.println("Auth not null ...");
        }
        
        if (session == null || !session.isLoggedIn()) {
            if (url.indexOf("main.xhtml") >= 0 || url.indexOf("logout.xhtml") >= 0) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.indexOf("register.xhtml") >= 0 || url.indexOf("login.xhtml") >= 0) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/main.xhtml");
            } else if (url.indexOf("logout.xhtml") >= 0) {
                req.getSession().removeAttribute("auth");
                resp.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
    
}
