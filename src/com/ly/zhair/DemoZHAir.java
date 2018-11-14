package com.ly.zhair;

import java.util.LinkedHashMap;
import com.alibaba.fastjson.JSONObject;
import com.ly.http.toolkit.HttpClient;
import com.ly.http.toolkit.HttpResult;

public class DemoZHAir {

    private static final String HOST = "mobile.shenzhenair.com";
    private static final String APP_VERSION = "4.0.7";
    private static final String DEVICE_TOKEN = "AhqwhDF5lShUB4iraA73jxzutN5ymk6ALG43pfu5su9_";

    public static void main(String[] args) {
        String userName = "15082319420";
        String password = "Hl15082319420";
        boolean isLogined = false;
        isLogined = login(userName, password);
    }

    private static boolean login(String userName, String password) {
        System.out.println("######################################### 登录 开始 #########################################");
        String url = "http://mobile.shenzhenair.com/szairMobileWS/services/memberLoginWebService?wsdl";

        JSONObject headerMetaJsonObj = new JSONObject();
        headerMetaJsonObj.put("app_version", APP_VERSION);
        headerMetaJsonObj.put("system_name", "ANDROID");
        headerMetaJsonObj.put("system_version", 22);
        headerMetaJsonObj.put("device_token", DEVICE_TOKEN);
        headerMetaJsonObj.put("device_type", "ANDROID");

        LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("User-Agent", "android(shenzhenair)" + APP_VERSION);
        headers.put("SOAPAction", "");
        headers.put("Content-Type", "text/xml; charset=utf-8");
        headers.put("X-SZAIR-META", headerMetaJsonObj.toJSONString());
        headers.put("Cookie", "JSESSIONID=6C91FDC0595F09CB041147E80007DD13-n1; Path=/szairMobileWS/; HttpOnly");
        headers.put("X-Tingyun-Processed", "true");
        headers.put("Host", HOST);
        headers.put("Connection", "Keep-Alive");

        String passwordEncrypted = EncryptClientUtils.getLoginPwd(password);
        String key = EncryptClientUtils.getKey();
        String bodyXML = SOAPEnvelope.getLoginSoapBodyXML(userName, passwordEncrypted);
        String requestXML = SOAPEnvelope.getRequestXML(key, bodyXML);
        String requestXMLEncrypted = EncryptClientUtils.encrypt(requestXML);
        System.out.println("==>> 请求明文:\n" + requestXML);
        System.out.println("----------------------------------------");

        HttpResult httpResult = HttpClient.httpPost(url, headers, requestXMLEncrypted);
        boolean isLogined = httpResult.getHttpResponse().getStatusLine().getStatusCode() == 200;
        assert isLogined;
        System.out.println("######################################### 登录 结束 #########################################");
        return isLogined;
    }

}
