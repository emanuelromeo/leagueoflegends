package com.develhope.leagueoflegends.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

    // Prima dell'esecuzione del controller
    @Override
    public boolean preHandle(

            HttpServletRequest request,
            HttpServletResponse response,
            Object handler

    ) throws Exception {

        // Logica pre-elaborazione
        System.out.println("Request: " + request);
        System.out.println("Response: " + response);
        System.out.println("Handler: " + handler);

        return true; // Continua la catena di interceptor

    }


    // Dopo l'esecuzione del controller, prima della view
    @Override
    public void postHandle(

            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView

    ) throws Exception {

        // Modifiche al model prima del rendering
        System.out.println("Request: " + request);
        System.out.println("Response: " + response);
        System.out.println("Handler: " + handler);
        System.out.println("Model: " + modelAndView);

    }


    // Dopo il completamento della richiesta
    @Override
    public void afterCompletion(

            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex

    ) throws Exception {

        // Pulizia risorse, logging finale
        System.out.println("Request: " + request);
        System.out.println("Response: " + response);
        System.out.println("Handler: " + handler);
        System.out.println("Exception: " + ex);

    }

}
