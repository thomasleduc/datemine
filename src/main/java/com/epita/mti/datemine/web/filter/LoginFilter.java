package com.epita.mti.datemine.web.filter;

import com.epita.mti.datemine.web.SessBean;
import java.io.IOException;
import javax.inject.Inject;
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
    
    @Inject
    SessBean session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //Auth session = (SessBean) req.getSession().getAttribute("auth");
        String url = req.getRequestURI();

        /*
        A. if request is for main or logout and there's no session, redirect the request to login.xhtml
        B. if request is for register or login and there's a session, redirect the request to main.xhtml
        C. if request is for logout and there's a session, remove the session, then redirect to login.xhtml
        */

        if (session == null || !session.isLoggedIn()) {
            if (url.contains("main.xhtml") || url.contains("logout.xhtml")) {
                resp.sendRedirect(req.getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("register.xhtml") || url.contains("login.xhtml")) {
                resp.sendRedirect(req.getContextPath() + "/main.xhtml");
            } else if (url.contains("logout.xhtml")) {
                session.setUsername(null);
                session.setLoggedIn(false);
                resp.sendRedirect(req.getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
