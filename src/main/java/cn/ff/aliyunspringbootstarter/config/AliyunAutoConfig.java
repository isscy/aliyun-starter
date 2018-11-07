package cn.ff.aliyunspringbootstarter.config;

import cn.ff.aliyunspringbootstarter.help.MnsProperties;
import cn.ff.aliyunspringbootstarter.help.OssProperties;
import cn.ff.aliyunspringbootstarter.template.AliyunMnsTemplate;
import cn.ff.aliyunspringbootstarter.template.AliyunOssTemplate;
import cn.ff.aliyunspringbootstarter.template.impl.DefaultAliyunMnsTemplate;
import cn.ff.aliyunspringbootstarter.template.impl.DefaultAliyunOssTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author ff 201811007
 */
@Configuration
// @ConditionalOnClass //当classpath下发现该类的情况下进行自动配置。
@EnableConfigurationProperties(value = {MnsProperties.class, OssProperties.class}) //启动配置文件
public class AliyunAutoConfig {

    /*
    @Autowired
    private MnsProperties mnsProperties;
    @Autowired
    private OssProperties ossProperties;
    */


    @Bean
    @ConditionalOnProperty(prefix = "aliyun.mns", value = "enable", havingValue = "true")
    AliyunMnsTemplate aliyunMnsTemplate(){
        return new DefaultAliyunMnsTemplate();
    }

    @Bean
    @ConditionalOnProperty(prefix = "aliyun.oss", value = "enable", havingValue = "true")
    AliyunOssTemplate aliyunOssTemplate(){
        return new DefaultAliyunOssTemplate();
    }
}
