package com.ly.study.thinkjava.generatecaptcha;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
/**
 * http 会话上下文
 * 
 * @author tkj09938
 * @version $Id: HttpContext.java, v 0.1 2016年8月3日 下午1:44:23 tkj09938 Exp $
 */
public class HttpContext {
    private HttpResponse response;
    private HttpRequestBase request;
    public HttpContext(HttpResponse response, HttpRequestBase request) {
        super();
        this.response = response;
        this.request = request;
    }
    public HttpResponse getResponse() {
        return response;
    }
    public void setResponse(HttpResponse response) {
        this.response = response;
    }
    public HttpRequestBase getRequest() {
        return request;
    }
    public void setRequest(HttpRequestBase request) {
        this.request = request;
    }

}
