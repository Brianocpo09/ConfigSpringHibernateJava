/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author sistemas
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            BddConfig.class, WebSecurityConfig.class
        };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
            MvcConfig.class
        };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }
    
}
