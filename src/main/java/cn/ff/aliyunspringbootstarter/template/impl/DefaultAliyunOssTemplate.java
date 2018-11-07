package cn.ff.aliyunspringbootstarter.template.impl;

import cn.ff.aliyunspringbootstarter.help.AliyunMnsRequest;
import cn.ff.aliyunspringbootstarter.help.OssProperties;
import cn.ff.aliyunspringbootstarter.template.AliyunOssTemplate;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

public class DefaultAliyunOssTemplate implements AliyunOssTemplate {

    @Autowired
    private OssProperties ossProperties;
    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultAliyunOssTemplate.class);

    @Override
    public void putObject(String name, InputStream input) {
        OSSClient client = ossProperties.getClient();
        PutObjectResult result = client.putObject(ossProperties.getBucketName(), name, input);

    }

    @Override
    public void askMe() {

        LOGGER.info("上传了图片");

    }
}
