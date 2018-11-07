package cn.ff.aliyunspringbootstarter.template.impl;

import cn.ff.aliyunspringbootstarter.help.AliyunMnsRequest;
import cn.ff.aliyunspringbootstarter.help.MnsProperties;
import cn.ff.aliyunspringbootstarter.template.AliyunMnsTemplate;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class DefaultAliyunMnsTemplate implements AliyunMnsTemplate {
    @Autowired
    private MnsProperties mnsProperties;
    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultAliyunMnsTemplate.class);

    @Override
    public void sendMsg(AliyunMnsRequest mnsRequest) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");// 短信API产品名称（短信产品名固定，无需修改）
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        final String accessKeyId = mnsProperties.getAccessKeyId();
        final String accessKeySecret = mnsProperties.getAccessKeySecret();
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();//组装请求对象
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(mnsRequest.getPhoneNumbers());
        String thisRequestSign = mnsRequest.getSignName();
        if (StringUtils.isEmpty(mnsRequest.getSignName()))
            request.setSignName(mnsProperties.getSignName());
        else
            request.setSignName(mnsRequest.getSignName());
        request.setTemplateCode(mnsRequest.getTemplateCode());
        request.setTemplateParam(mnsRequest.getTemplateParam());
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK"))
            return;
        throw new ClientException(sendSmsResponse.getCode(), sendSmsResponse.getMessage(), sendSmsResponse.getRequestId());
    }

    @Override
    public void askMe(AliyunMnsRequest mnsRequest) {
        LOGGER.info("发送了短信 " + mnsRequest.getPhoneNumbers() + "  , 参数： " + mnsRequest.getTemplateParam());
    }
}
