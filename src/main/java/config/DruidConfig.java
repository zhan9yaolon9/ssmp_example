package config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: frank
 * @Date: 2023/03/24/13:53
 * @Description:    druid配置类
 **/
@Configuration
public class DruidConfig {

    /**
     * 自定义的 Druid数据源添加到selvet容器
     * 绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource从而让它们生效
     */
    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    /**
     * 后台日志监控
     * 设置后台管理页面
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<StatViewServlet>
                        (new StatViewServlet(),"/druid/*");
        //设置初始化参数
        Map<String,String> initParas = new HashMap<String,String>();
        initParas.put("loginUsername","admin");
        initParas.put("loginPassword","123456");
        //允许谁能访问
        initParas.put("allow",""); //允许所有人访问
        //initParars.put("allow","localhost"); //只有本机能访问
        //initParars.put("deny",""); //拒绝访问
        initParas.put("resetEnable","false"); //禁用html中的reset按钮
        bean.setInitParameters(initParas);
        return bean;
    }

    /**
     * 过滤器： 配置过滤请求，需要统计哪些sql的信息
     * WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //"/*" 表示过滤所有请求
        bean.addUrlPatterns("/*");
        //可以过滤和排除哪些东西
        Map<String,String> initParams = new HashMap<String,String>();
        //把不需要监控的过滤掉,这些不进行统计
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }
}
