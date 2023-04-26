package com.sysmsg.config;

import com.sysmsg.Utils.MessageUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * （1）MessageUtils注入容器。
 * （2）设置i18资源文件读取的路径。（messageSource()方法）
 * （3）设置默认本地语言解析器。唯有配置了这个才能系统可以根据浏览器的默认语言设置进行语言切换。（localeResolver()方法）
 * （4）默认拦截器 其中lang表示切换语言的参数名。（localeInterceptor()）
 */
@Configuration
public class LocaleConfig {

    @Bean
    public MessageUtils messageUtils() {
        return new MessageUtils(messageSource());
    }

    /**
     *资源文件路径
     **/
    @Bean
    public ResourceBundleMessageSource messageSource() {
        Locale.setDefault(Locale.CHINESE);
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        /*ame of the resource bundle*/
        source.setBasenames("i18n/sysmsg","i18n/userGeneral", "i18n/pageGeneral", "i18n/webValidator");
        //默认是false，调试设置为true
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }


    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // localeResolver.setDefaultLocale(Locale.UK);
        return localeResolver;
    }

    /**
     * 默认拦截器 其中lang表示切换语言的参数名
     */
    @Bean
    public WebMvcConfigurer localeInterceptor() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
                localeInterceptor.setParamName("lang");
                registry.addInterceptor(localeInterceptor);
            }
        };
    }
}

