package com.lyw.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 13:39
 */
@SpringBootApplication(scanBasePackages = {"com.lyw"},
        exclude = DataSourceAutoConfiguration.class)
@ImportResource({
        "classpath*:/spring/applicationContext*.xml",
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@EnableCaching
public class ApplicationRunner {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(ApplicationRunner.class, args));
    }
}
