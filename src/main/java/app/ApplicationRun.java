package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableCaching //启用缓存
@EntityScan("pojo")
@MapperScan("dao")	//扫描dao包
//扫描service包
//扫描controller包
@ComponentScan({"service", "controller", "config", "utils"})
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
