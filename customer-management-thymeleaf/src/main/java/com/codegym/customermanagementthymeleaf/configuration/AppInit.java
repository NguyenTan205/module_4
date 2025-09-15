package com.codegym.customermanagementthymeleaf.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {       //tầng core (service, DAO, security).
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    // tầng web (controller, view resolver).
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {       // URL nào do Spring MVC xử lý.
        return new String[]{"/"};
    }
}
