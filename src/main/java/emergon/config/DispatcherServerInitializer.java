/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Leyteris
 */
public class DispatcherServerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] myServletConfigClasses = {MyDispatcherServletConfiguration.class};
        return myServletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] myServletMappings = {"/"};
        return myServletMappings;
    }

}
