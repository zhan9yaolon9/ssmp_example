package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: frank
 * @Date: 2023/03/19/18:58
 * @Description: swagger配置类
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("controller")) //你的项目基础包名
                .paths(PathSelectors.any())
                .build();
    }
    //配置swagger信息  apiinfo
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("ssmp_example_swaggerUI")
                .description("ssmp_example的swagger文档")
                .version("v1.0")
                //服务条款网址
                .termsOfServiceUrl("https://localhost:80/test")
                .build();

    }
}
