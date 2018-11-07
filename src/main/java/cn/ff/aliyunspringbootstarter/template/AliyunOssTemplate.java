package cn.ff.aliyunspringbootstarter.template;

import cn.ff.aliyunspringbootstarter.help.AliyunMnsRequest;

import java.io.InputStream;

public interface AliyunOssTemplate {

    void putObject(String name, InputStream input);

    default void askMe(){
        System.out.println("me: this is aLiYun Starter By ff");
    }
}
