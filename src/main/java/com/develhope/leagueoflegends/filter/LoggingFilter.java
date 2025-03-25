package com.develhope.leagueoflegends.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;


import java.io.IOException;

import java.util.logging.Logger;


@Component

public class LoggingFilter implements Filter {


    private static final Logger LOGGER = Logger.getLogger(LoggingFilter.class.getName());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        LOGGER.info("Filter inizializzato");

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOGGER.info("Richiesta in arrivo: " + request.getProtocol());

        chain.doFilter(request, response);

        LOGGER.info("Risposta inviata: " + response.getContentType());

    }


    @Override
    public void destroy() {

        LOGGER.info("Filter distrutto");

    }

}
