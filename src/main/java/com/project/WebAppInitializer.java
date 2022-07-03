package com.project;

//CLASE DE PRUEBA PARA MAPEAR THYMELEAF
/*import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext){

        //CARGA EL ARCHIVO DE CONFIGURACION
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(config.class);

        //CREA Y REGISTRAR EL DISPACHER SERVLET
        DispatcherServlet servlet=new DispatcherServlet(context);
        ServletRegistration.Dynamic registration=servletContext.addServlet("app",servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");


    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{config.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}*/
