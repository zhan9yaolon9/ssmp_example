package config;

/**
 * @Author: frank
 * @Date: 2023/03/21/21:27
 * @Description:
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置属性类
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtConfigProperties{
    //过期时间
    private long expire;
    //密钥
    private String secret;
}
