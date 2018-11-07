package cn.ff.aliyunspringbootstarter.template;

import cn.ff.aliyunspringbootstarter.help.AliyunMnsRequest;
import com.aliyuncs.exceptions.ClientException;

/**
 * 阿里云短信服务模版
 * @author ff 20181107
 */
public interface AliyunMnsTemplate {

    void sendMsg(AliyunMnsRequest mnsRequest) throws ClientException;


    default void askMe(AliyunMnsRequest mnsRequest){
        System.out.println("me: this is aLiYun Starter By ff");
    }
}
