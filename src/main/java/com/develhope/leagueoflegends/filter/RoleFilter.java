package com.develhope.leagueoflegends.filter;

import com.develhope.leagueoflegends.enumeration.ChampionRole;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;

import java.util.logging.Logger;

public class RoleFilter implements Filter {


    private static final Logger LOGGER = Logger.getLogger(RoleFilter.class.getName());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        LOGGER.info("Filter initialized");

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOGGER.info("Arriving request: " + request.getProtocol());

        if (ChampionRole.FIGHTER.toString().equalsIgnoreCase(request.getParameter("role"))) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/champions/find-all");
            return;
        }

        chain.doFilter(request, response);

        LOGGER.info("Sent response: " + response.getContentType());

    }


    @Override
    public void destroy() {

        LOGGER.info("Filter destroyed");

    }

}
