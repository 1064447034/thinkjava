package com.ly.zhair;

public class SOAPEnvelope {
    private static final String DEVICE_TOKEN = "AhqwhDF5lShUB4iraA73jxzutN5ymk6ALG43pfu5su9_";
    private static final String DEVICE_TYPE = "ANDROID";
    private static final String APP_ID = "5";
    private static final String APP_IP = "127.0.0.1";

    public static String getRequestXML(String key, String soapBody) {
        return "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>" + "\r\n"
                + "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" + "\r\n"
                + "  <soap:Header MOBILE_TYPE=\"" + key + "\" />" + "\r\n"
                + "  <soap:Body>" + "\r\n"
                + soapBody + "\r\n"
                + "  </soap:Body>" + "\r\n"
                + "</soap:Envelope>";
    }

    public static String getLoginSoapBodyXML(String userName, String password) {
        return "    <ns0:login xmlns:ns0=\"http://com/szcares/member/webservice/login\">" + "\r\n"
                + "      <LOGIN_PARAM>" + "\r\n"
                + "        <DEVICE_TOKEN>" + DEVICE_TOKEN + "</DEVICE_TOKEN>" + "\r\n"
                + "        <DEVICE_TYPE>" + DEVICE_TYPE + "</DEVICE_TYPE>" + "\r\n"
                + "        <PASSWORD>" + password + "</PASSWORD>" + "\r\n"
                + "        <USER_NAME>" + userName + "</USER_NAME>" + "\r\n"
                + "        <APP_ID>" + APP_ID + "</APP_ID>" + "\r\n"
                + "        <APP_IP>" + APP_IP + "</APP_IP>" + "\r\n"
                + "      </LOGIN_PARAM>" + "\r\n"
                + "    </ns0:login>";
    }

}
