package com.ly.zhair;

import com.alibaba.fastjson.JSONObject;
import com.ly.flight.cipher.EncryptClient;

public class EncryptClientUtils {

	private static EncryptClient encryptClient = new EncryptClient("10.14.84.140");

    public static String getLoginPwd(String data) {
        JSONObject paramJsonObj = new JSONObject();
        paramJsonObj.put("data", data);

        JSONObject postDataJsonObj = new JSONObject();
        postDataJsonObj.put("appType", "ticket");
        postDataJsonObj.put("appCode", "ZH");
        postDataJsonObj.put("opType", "encrypt");
        postDataJsonObj.put("subOpType", "loginPwd");
        postDataJsonObj.put("param", paramJsonObj);
        try {
            return encryptClient.callFunc(postDataJsonObj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getKey() {
        JSONObject postDataJsonObj = new JSONObject();
        postDataJsonObj.put("appType", "ticket");
        postDataJsonObj.put("appCode", "ZH");
        postDataJsonObj.put("opType", "encrypt");
        postDataJsonObj.put("subOpType", "getKey");
        postDataJsonObj.put("param", new JSONObject());
        try {
            return encryptClient.callFunc(postDataJsonObj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public static String encrypt(String data) {
		JSONObject paramJsonObj = new JSONObject();
		paramJsonObj.put("data", data);

		JSONObject postDataJsonObj = new JSONObject();
		postDataJsonObj.put("appType", "ticket");
		postDataJsonObj.put("appCode", "ZH");
		postDataJsonObj.put("opType", "encrypt");
		postDataJsonObj.put("subOpType", "nocare");
		postDataJsonObj.put("param", paramJsonObj);
		try {
			return encryptClient.callFunc(postDataJsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
        String password = getLoginPwd("Hl15082319420");
        String key = getKey();

        String bodyXML = SOAPEnvelope.getLoginSoapBodyXML("15082319420", password);
        String requestXML = SOAPEnvelope.getRequestXML(key, bodyXML);
        System.out.println(requestXML);
		System.out.println();
		System.out.println(encrypt(requestXML));
	}
}
