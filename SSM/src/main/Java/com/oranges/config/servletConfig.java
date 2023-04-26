package com.oranges.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class servletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 返回的带有@Configuration注解的类用来配置ContextLoaderListener
     * 加载spring配置类
     *
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{springConfig.class};
    }

    /**
     * 返回的带有@Configuration注解的类用来配置DispatcherServlet
     * 加载SpringMVC配置类
     *
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{springMvcConfig.class};
    }

    /**
     * 将一个或多个路径映射到DispatcherServlet上
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
