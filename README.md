# aliyun-spring-boot-starter

阿里云短信和oss的 starter

maven 

```
	<dependency>
		<groupId>cn.ff</groupId>
		<artifactId>aliyun-spring-boot-starter</artifactId>
		<version>0.9.0</version>
	</dependency>
```
配置 application.yml:
<font color='#23ca14' size=4 >

```
aliyun:
    mns:
        access-key-id: 您的key
        access-key-secret: 您的secret
        sign-name: 您的sign
        enable: true
    oss:
        endpoint: 断点 例如：oss-cn-beijing.aliyuncs.com
        accessKeyId: 您的key
        accessKeySecret: 您的secret
        bucketName: 您的bucket
        lookUrl: 图片的查看路径
```
</font>
demo:

```
	@Autowired
    private AliyunMnsTemplate aliyunMnsTemplate;
	
	public void sendSms(String phoneNum){
		//短信模板
		String templateNo = "SMS_142365071";
		//验证码
		String code = "123456";
		aliyunMnsTemplate.sendMsg(new AliyunMnsRequest(templateNo, phone).setParam("code", code));
	}
```
