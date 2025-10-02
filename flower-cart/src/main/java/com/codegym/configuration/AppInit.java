package com.codegym.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // load cấu hình chính (AppConfiguration có WebMvcConfigurer)
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // không có servlet config riêng
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
