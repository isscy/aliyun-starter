package cn.ff.aliyunspringbootstarter.help;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 短信服务配置文件
 */
@Data
@ConfigurationProperties("aliyun.mns")
public class MnsProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String signName;

    private String enable;


}
