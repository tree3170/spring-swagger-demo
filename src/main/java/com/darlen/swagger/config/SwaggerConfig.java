package com.darlen.swagger.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/1/5 23:00
 * @Version 1.0
 */
@Configuration		//让Spring来加载该类配置
@EnableWebMvc        //启用Mvc，非springboot框架需要引入注解@EnableWebMvc
@EnableSwagger2		//启用Swagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户")
                .select()  // 选择那些路径和api会生成document
                //扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.xia.controller"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .apiInfo(userInfo());
    }



    private ApiInfo userInfo() {
        return new ApiInfoBuilder()
                .title("基础平台 RESTful APIs")
                .description("基础平台 RESTful 风格的接口文档，内容详细极大的减少了前后端的沟通成本，同时确保代码与文档保持高度一致，极大的减少维护文档的时间。")
                .termsOfServiceUrl("http://xiachengwei5.coding.me")
                .contact("Darlen")
                //.license("个人博客")
                //.licenseUrl("http://xiachengwei5.coding.me")
                .version("0.0.1")
                .build();
    }

}
