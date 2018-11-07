package cn.ff.aliyunspringbootstarter.help;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 对象存储配置类
 * @author ff at 20181107
 */
@Data
@ConfigurationProperties("aliyun.oss")
public class OssProperties {
    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String lookUrl;

    public OSSClient getClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }


}
