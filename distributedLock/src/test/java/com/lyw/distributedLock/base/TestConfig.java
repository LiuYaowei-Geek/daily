package com.lyw.distributedLock.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ImportResource({"classpath*:/spring/test-applicationContext*.xml"})
//@PropertySource({"classpath:env.properties", "classpath:datasource.properties"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"com.lyw"}, exclude = DataSourceAutoConfiguration.class)
public class TestConfig
        //extends WebMvcConfigurerAdapter
{
//    @Bean
//    public WebDigestHandlerInterceptor webDigestHandlerInterceptor() {
//        return new WebDigestHandlerInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new WebTraceHandlerInterceptor());
//        registry.addInterceptor(webDigestHandlerInterceptor());
//    }
}
