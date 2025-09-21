package com.codegym.ormsonglisten.configuration;

import com.codegym.ormsonglisten.configuration.AppConfiguration;
import jakarta.servlet.MultipartConfigElement;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(jakarta.servlet.ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(
                null, 10 * 1024 * 1024, 10 * 1024 * 1024, 0)); // 5MB
    }
}