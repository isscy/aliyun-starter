package cn.ff.aliyunspringbootstarter.help;

import com.google.gson.Gson;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云短信服务 请求参数的封装类
 */
@Data
public class AliyunMnsRequest {


    private Map<String, String> params = new HashMap<>();

    private String phoneNumbers;

    private String templateCode;

    private String signName;

    private static final Gson gson = new Gson();

    public AliyunMnsRequest() {
    }

    public AliyunMnsRequest(String templateCode) {
        this.templateCode = templateCode;
    }

    public AliyunMnsRequest(String templateCode, String phoneNumbers) {
        this.templateCode = templateCode;
        this.phoneNumbers = phoneNumbers;
    }

    public AliyunMnsRequest setParams(Map<String, String> params) {
        this.params.putAll(params);
        return this;
    }

    public AliyunMnsRequest setParam(String key, String value) {
        this.params.put(key, value);
        return this;
    }

    public String getTemplateParam() {
        return gson.toJson(this.params);
    }



}
