package top.slrjy.edu.Config.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @auther luc
 * @desc 拦截器配置类
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public SpringContextHolder springContextHolder(){
        return new SpringContextHolder();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：可以定义拦截的url和不拦截的url
       // registry.addInterceptor(new UniqueUserInfoInterceptor ()).addPathPatterns("/**").excludePathPatterns("/login/**").excludePathPatterns("favicon.ico");
        System.out.println(registry);
        super.addInterceptors(registry);

    }
}

