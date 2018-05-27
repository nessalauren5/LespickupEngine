package com.lespickup.controller;
import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInit  extends AbstractAnnotationConfigDispatcherServletInitializer{

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] {SConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }

        @Override
        public void onStartup(ServletContext servletContext)
                throws ServletException {
            super.onStartup(servletContext);
            ServletRegistration.Dynamic servlet = servletContext.addServlet(
                    "h2-console", new WebServlet());
            servlet.setLoadOnStartup(2);
            servlet.addMapping("/console/*");
        }

}
