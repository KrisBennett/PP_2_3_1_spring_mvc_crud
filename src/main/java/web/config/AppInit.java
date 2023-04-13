package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Метод, указывающий на класс конфигурации.
     *
     * @return null
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * Добавление конфигурации, в которой инициализируем ViewResolver,
     * для корректного отображения jsp.
     *
     * @return Class<?>[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebAppConfig.class
        };
    }

    /**
     * Метод, указывающий url, на котором будет базироваться приложение.
     *
     * @return String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null, true, "/*");
    }

}

