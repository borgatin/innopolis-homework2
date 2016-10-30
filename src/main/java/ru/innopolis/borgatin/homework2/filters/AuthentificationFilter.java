package ru.innopolis.borgatin.homework2.filters;

import ru.innopolis.borgatin.homework2.entity.User;

import javax.servlet.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by avborg on 30.10.2016.
 */
public class AuthentificationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        User user = (User) request.getAttribute("user");
        if (user!=null){
            chain.doFilter(request,response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
