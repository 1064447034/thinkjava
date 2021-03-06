package com.ly.study.thinkjava.generatecaptcha;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

/**
 * httpclient 简单工具类
 * 
 * @author tkj09938
 * @version $Id: HttpClientUtil.java, v 0.1 2016年5月10日 上午9:59:38 tkj09938 Exp $
 */
public class HttpClientUtil {

	/**
	 * 处理get请求
	 * 
	 * @param httpClient
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static HttpContext doGet(HttpClient httpClient, String url) throws IOException {
		return doGet(httpClient, url, new HashMap<String, Object>());
	}

	/**
	 * 处理get请求
	 * 
	 * @param client
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static HttpContext doGet(HttpClient client, String url, Map<String, Object> params) throws IOException {

		return doGet(client, url, params, new HashMap<String, String>());

	}

	/**
	 * 处理get请求
	 * 
	 * @param client
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpContext doGet(HttpClient client, String url, Map<String, Object> params,
			Map<String, String> headers) throws ClientProtocolException, IOException {
		StringBuffer param = new StringBuffer();
		if (!params.isEmpty()) {
			int i = 0;
			for (String key : params.keySet()) {
				if (i++ == 0) {
					param.append("?");
				} else {
					param.append("&");
				}
				param.append(key).append("=").append(params.get(key));
			}
		}
		HttpGet getRequest = new HttpGet(url + param.toString());
		initHttpHeader(getRequest, headers);
		HttpResponse response;
		response = client.execute(getRequest);

		return new HttpContext(response, getRequest);
	}

	/**
	 * 处理get请求
	 * 不自动重定向
	 * @param client
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpContext doGetNoRedirect(HttpClient client, String url, Map<String, Object> params,
			Map<String, String> headers) throws ClientProtocolException, IOException {
		StringBuffer param = new StringBuffer();
		if (!params.isEmpty()) {
			int i = 0;
			for (String key : params.keySet()) {
				if (i++ == 0) {
					param.append("?");
				} else {
					param.append("&");
				}
				param.append(key).append("=").append(params.get(key));
			}
		}
		HttpGet getRequest = new HttpGet(url + param.toString());
		initHttpHeader(getRequest, headers);
        RequestConfig requestConfig = RequestConfig.custom().setRedirectsEnabled(false).build();
        getRequest.setConfig(requestConfig);
		HttpResponse response;
		response = client.execute(getRequest);

		return new HttpContext(response, getRequest);
	}
    
	/**
	 * 处理空参post
	 * 
	 * @param client
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static HttpContext doPost(HttpClient client, String url) throws IOException {
		return doPost(client, url, new HashMap<String, Object>());
	}

	/**
	 * 处理带有表单参数的post
	 * 
	 * @param client
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static HttpContext doPost(HttpClient client, String url, Map<String, Object> params) throws IOException {
		return doPost(client, url, params, new HashMap<String, String>());
	}

	/**
	 * 处理带有表单参数和消息头的post
	 * 
	 * @param client
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public static HttpContext doPost(HttpClient client, String url, Map<String, Object> params,
			Map<String, String> headers) throws IOException {
		HttpPost postRequest = new HttpPost(url);
		initHttpHeader(postRequest, headers);
		// 构造表单参数
		if (params != null && !params.isEmpty()) {
			List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
			for (String key : params.keySet()) {
				if (params.get(key) != null) {
					NameValuePair pair = new BasicNameValuePair(key, params.get(key).toString());
					pairList.add(pair);
				}
			}
			postRequest.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
		}
		HttpResponse response = client.execute(postRequest);
		return new HttpContext(response, postRequest);
	}

	public static HttpContext doURLPost(HttpClient client,String url, Map<String, Object> params,Map<String, String> headers) throws IOException {
		// 构造表单参数
		List<NameValuePair> pairList =null;
		if (params != null && !params.isEmpty()) {
			pairList = new ArrayList<NameValuePair>(params.size());
			for (String key : params.keySet()) {
				if (params.get(key) != null) {
					NameValuePair pair = new BasicNameValuePair(key, params.get(key).toString());
					pairList.add(pair);
				}
			}
		}
		String strUrlParams = URLEncodedUtils.format(pairList, Charset.forName("UTF-8"));
		HttpPost httpPost = new HttpPost(url + "?" + strUrlParams);
		Iterator var6 = headers.entrySet().iterator();

		while(var6.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry)var6.next();
			if(!entry.getKey().equalsIgnoreCase("Content-Length")) {
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
		}

		StringEntity requestEntity = new StringEntity("", ContentType.TEXT_PLAIN);
		httpPost.setEntity(requestEntity);
		HttpResponse response = client.execute(httpPost);
		return new HttpContext(response, httpPost);
	}


	/**
	 * 处理其他类型post
	 * 
	 * @param client
	 * @param url
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static HttpContext doPost(HttpClient client, String url, String param) throws Exception {
		return doPost(client, url, param, new HashMap<String, String>());
	}

	/**
	 * 处理其他类型post
	 * 
	 * @param client
	 * @param url
	 * @param param
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	public static HttpContext doPost(HttpClient client, String url, String param, Map<String, String> headers)
			throws Exception {
		HttpPost postRequest = new HttpPost(url);
		initHttpHeader(postRequest, headers);
		// set proxy
		// HttpHost proxy = new HttpHost("10.14.60.30", 8085,"http");
		// RequestConfig config =
		// RequestConfig.custom().setProxy(proxy).build();
		// postRequest.setConfig(config);
		StringEntity stringEn = new StringEntity(param, "UTF-8");
		postRequest.setEntity(stringEn);
		HttpResponse response = client.execute(postRequest);
		return new HttpContext(response, postRequest);
	}

	public static HttpContext doPostNoDirect(HttpClient client, String url, String param, Map<String, String> headers) throws Exception {
		HttpPost postRequest = new HttpPost(url);
	
		RequestConfig requestConfig = RequestConfig.custom().setRedirectsEnabled(false).build();
	    postRequest.setConfig(requestConfig);
	    
		initHttpHeader(postRequest, headers);
		// set proxy
		// HttpHost proxy = new HttpHost("10.14.60.30", 8085,"http");
		// RequestConfig config =
		// RequestConfig.custom().setProxy(proxy).build();
		// postRequest.setConfig(config);
		StringEntity stringEn = new StringEntity(param, "UTF-8");
		postRequest.setEntity(stringEn);
		HttpResponse response = client.execute(postRequest);
		return new HttpContext(response, postRequest);
	}
	
	public static HttpContext doPostDirect(HttpClient client, String url, String param, Map<String, String> headers) throws Exception {
		HttpPost postRequest = new HttpPost(url);
	
		RequestConfig requestConfig = RequestConfig.custom().setRedirectsEnabled(true).build();
	    postRequest.setConfig(requestConfig);
	    
		initHttpHeader(postRequest, headers);
		// set proxy
		// HttpHost proxy = new HttpHost("10.14.60.30", 8085,"http");
		// RequestConfig config =
		// RequestConfig.custom().setProxy(proxy).build();
		// postRequest.setConfig(config);
		StringEntity stringEn = new StringEntity(param, "UTF-8");
		postRequest.setEntity(stringEn);
		HttpResponse response = client.execute(postRequest);
		return new HttpContext(response, postRequest);
	}
	
	public static HttpContext doPost(HttpClient client, String url, byte[] bytes, Map<String, String> headers) throws Exception {
		HttpPost postRequest = new HttpPost(url);
		initHttpHeader(postRequest, headers);
		postRequest.setEntity(new ByteArrayEntity(bytes));
		HttpResponse response = client.execute(postRequest);
		return new HttpContext(response, postRequest);
	}
	
	/**
	 * 初始化http消息头
	 * 
	 * @param client
	 * @param headers
	 */
	private static void initHttpHeader(HttpRequestBase request, Map<String, String> headers) {
		if (headers != null && !headers.isEmpty()) {
			for (String key : headers.keySet()) {
				if (!StringUtils.isEmpty(headers.get(key))) {
					request.addHeader(key, headers.get(key));
				}
			}
		}

	}

	/**
	 * 解析http响应状态码
	 * 
	 * @param httpResponse
	 * @return
	 */
	public static int getResponseCode(HttpResponse httpResponse) {
		if (httpResponse != null) {
			return httpResponse.getStatusLine().getStatusCode();
		}
		return 0;
	}

	/**
	 * 使用默认的编码解析http响应实体
	 * 
	 * @param httpResponse
	 * @return
	 */
	public static String getResponseContent(HttpContext httpContext) throws Exception {
		return getResponseContent(httpContext, "UTF-8");
	}

	/**
	 * 将http 响应实体解析为字节数组
	 * 
	 * @param httpResponse
	 * @return
	 * @throws Exception
	 */
	public static byte[] getResponseContentBytes(HttpContext httpContext) throws Exception {
		byte[] result = null;
		try {
			if (httpContext.getResponse() != null) {
				result = EntityUtils.toByteArray(httpContext.getResponse().getEntity());
			}
		} catch (Exception e) {
			throw e;
		} finally {
			EntityUtils.consume(httpContext.getResponse().getEntity());
			httpContext.getRequest().abort();
		}
		return result;
	}

	/**
	 * 以特定的字符集编码解析http响应实体
	 * 
	 * @param httpResponse
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String getResponseContent(HttpContext httpContext, String charset) throws Exception {
		String result = "";
		try {
			if (httpContext.getResponse() != null) {
				result = EntityUtils.toString(httpContext.getResponse().getEntity(), charset);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			EntityUtils.consume(httpContext.getResponse().getEntity());
			httpContext.getRequest().abort();
		}
		return result;
	}

	/**
	 * 获取默认的httpClient
	 * 
	 * @return
	 */
	// public static CloseableHttpClient getDefaultHttpClient() {
	// RequestConfig config =
	// RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
	// .setConnectTimeout(10 * 1000).setSocketTimeout(20 * 1000).build();
	// return HttpClients.custom().setDefaultRequestConfig(config).build();
	// }
	public static CloseableHttpClient getDefaultHttpClient() {
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
				.setConnectTimeout(10 * 1000).setSocketTimeout(20 * 1000).build();
		SSLContext sslcontext = null;
		PoolingHttpClientConnectionManager connectionManager = null;
		try {
			sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
			connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(20);
		} catch (Exception e) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(20);
		}
		return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(config)
				.setConnectionManagerShared(true).build();
	}

	/**
	 * 获取默认的httpClient
	 * 
	 * @return
	 */
	// public static CloseableHttpClient getDefaultHttpClient(int
	// connectTimeout, int socketTimeout) {
	// RequestConfig config =
	// RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
	// .setConnectTimeout(connectTimeout * 1000).setSocketTimeout(socketTimeout
	// * 1000).build();
	// return HttpClients.custom().setDefaultRequestConfig(config).build();
	// }
	public static CloseableHttpClient getDefaultHttpClient(int connectTimeout, int socketTimeout) {
		SSLContext sslcontext = null;
		PoolingHttpClientConnectionManager connectionManager = null;
		try {
			sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
			connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(20);
		} catch (Exception e) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(20);
		}
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
				.setConnectTimeout(connectTimeout * 1000).setSocketTimeout(socketTimeout * 1000).build();
		return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(config)
				.setConnectionManagerShared(true).build();
	}

	/**
	 * 获取使用代理的httpClient
	 * 
	 * @return
	 */
	/*
	 * public static CloseableHttpClient getHttpClientWithProxy() {
	 * RequestConfig config =
	 * RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
	 * .setProxy(getProxyHost()).setConnectTimeout(10 *
	 * 1000).setSocketTimeout(20 * 1000).build(); CredentialsProvider
	 * credsProvider = new BasicCredentialsProvider();
	 * credsProvider.setCredentials(new AuthScope("10.14.60.30", 8087), new
	 * UsernamePasswordCredentials("baiyi3", "baiyi3")); return
	 * HttpClients.custom().setDefaultRequestConfig(config).
	 * setDefaultCredentialsProvider(credsProvider) .build(); }
	 */ /**
		 * 获取使用代理的httpClient
		 * 
		 * @return
		 * @throws NoSuchAlgorithmException
		 * @throws KeyManagementException
		 */

	/** 支持祥鹏，新方法 */
	/*
	 * @SuppressWarnings("all") public static CloseableHttpClient
	 * getHttpClientWithProxy() { SSLSocketFactory socketFactory = null; try {
	 * X509TrustManager xtm = new X509TrustManager() { public void
	 * checkClientTrusted(X509Certificate[] chain, String authType) throws
	 * CertificateException {} public void checkServerTrusted(X509Certificate[]
	 * chain, String authType) throws CertificateException {} public
	 * X509Certificate[] getAcceptedIssuers() { return null; } };
	 * X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
	 * public boolean verify(String arg0, SSLSession arg1) { return true; }
	 * public void verify(String arg0, SSLSocket arg1) throws IOException {}
	 * public void verify(String arg0, String[] arg1, String[] arg2) throws
	 * SSLException {} public void verify(String arg0, X509Certificate arg1)
	 * throws SSLException {} }; SSLContext ctx = SSLContext.getInstance("TLS");
	 * ctx.init(null, new TrustManager[] { xtm }, null); socketFactory = new
	 * SSLSocketFactory(ctx);
	 * socketFactory.setHostnameVerifier(hostnameVerifier); } finally {
	 * RequestConfig config =
	 * RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
	 * .setProxy(getProxyHost()).setConnectTimeout(10 *
	 * 1000).setSocketTimeout(20 * 1000).build();
	 * 
	 * PoolingHttpClientConnectionManager connectionManager = new
	 * PoolingHttpClientConnectionManager(); connectionManager.setMaxTotal(400);
	 * // connectionManager.setDefaultMaxPerRoute(100); //
	 * 
	 * CredentialsProvider credsProvider = new BasicCredentialsProvider();
	 * credsProvider.setCredentials(new AuthScope("10.14.60.30", 8087), new
	 * UsernamePasswordCredentials("baiyi3", "baiyi3")); return
	 * HttpClients.custom().setSSLSocketFactory(socketFactory).
	 * setDefaultRequestConfig(config).setDefaultCredentialsProvider(
	 * credsProvider) .setConnectionManagerShared(true).build(); } }
	 */
	public static CloseableHttpClient getHttpClientWithProxy() {
		SSLContext sslcontext = null;
		PoolingHttpClientConnectionManager connectionManager = null;
		try {
			sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
			connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(20);
		} catch (Exception e) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(20);
		}
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).setProxy(getProxyHost())
				.setConnectTimeout(10 * 1000).setSocketTimeout(20 * 1000).build();

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope("10.14.60.30", 8087),
				new UsernamePasswordCredentials("baiyi3", "baiyi3"));

		return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(config)
				.setDefaultCredentialsProvider(credsProvider).setConnectionManagerShared(true).build();
	}

	/**
	 * 获取使用代理的httpClient
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	/*
	 * public static CloseableHttpClient getHttpClientWithProxy(String
	 * proxyInfo, int connectTimeout, int socketTimeout) { String[] infoArray =
	 * proxyInfo.split(":");
	 * 
	 * RequestConfig config =
	 * RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
	 * .setProxy(new HttpHost(infoArray[0], Integer.parseInt(infoArray[1]),
	 * "http")) .setConnectTimeout(connectTimeout * 1000)
	 * .setSocketTimeout(socketTimeout * 1000)
	 * .setConnectionRequestTimeout(socketTimeout * 1000) // .build();
	 * 
	 * PoolingHttpClientConnectionManager connectionManager = new
	 * PoolingHttpClientConnectionManager(); connectionManager.setMaxTotal(400);
	 * // connectionManager.setDefaultMaxPerRoute(100); //
	 * 
	 * if (infoArray.length == 4) { CredentialsProvider credsProvider = new
	 * BasicCredentialsProvider(); credsProvider.setCredentials(new
	 * AuthScope(infoArray[0], Integer.parseInt(infoArray[1])), new
	 * UsernamePasswordCredentials(infoArray[2], infoArray[3])); return
	 * HttpClients.custom().setDefaultRequestConfig(config).
	 * setDefaultCredentialsProvider(credsProvider)
	 * .setConnectionManager(connectionManager)
	 * .setConnectionManagerShared(true).build(); }
	 * 
	 * return HttpClients.custom().setDefaultRequestConfig(config).
	 * setConnectionManagerShared(true).setConnectionManager(connectionManager).
	 * build(); }
	 */
	/** 支持祥鹏，新方法 */
	/*
	 * @SuppressWarnings("all") public static CloseableHttpClient
	 * getHttpClientWithProxy(String proxyInfo, int connectTimeout, int
	 * socketTimeout) { String[] infoArray = proxyInfo.split(":");
	 * 
	 * RequestConfig config =
	 * RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
	 * .setProxy(new HttpHost(infoArray[0], Integer.parseInt(infoArray[1]),
	 * "http")) .setConnectTimeout(connectTimeout * 1000)
	 * .setSocketTimeout(socketTimeout * 1000)
	 * .setConnectionRequestTimeout(socketTimeout * 1000) // .build();
	 * 
	 * PoolingHttpClientConnectionManager connectionManager = new
	 * PoolingHttpClientConnectionManager(); connectionManager.setMaxTotal(400);
	 * // connectionManager.setDefaultMaxPerRoute(100); //
	 * 
	 * SSLSocketFactory socketFactory = null; try { X509TrustManager xtm = new
	 * X509TrustManager() { public void checkClientTrusted(X509Certificate[]
	 * chain, String authType) throws CertificateException {} public void
	 * checkServerTrusted(X509Certificate[] chain, String authType) throws
	 * CertificateException {} public X509Certificate[] getAcceptedIssuers() {
	 * return null; } }; X509HostnameVerifier hostnameVerifier = new
	 * X509HostnameVerifier() { public boolean verify(String arg0, SSLSession
	 * arg1) { return true; } public void verify(String arg0, SSLSocket arg1)
	 * throws IOException {} public void verify(String arg0, String[] arg1,
	 * String[] arg2) throws SSLException {} public void verify(String arg0,
	 * X509Certificate arg1) throws SSLException {} }; SSLContext ctx =
	 * SSLContext.getInstance("TLS"); ctx.init(null, new TrustManager[] { xtm },
	 * null); socketFactory = new SSLSocketFactory(ctx);
	 * socketFactory.setHostnameVerifier(hostnameVerifier); } finally { if
	 * (infoArray.length == 4) { CredentialsProvider credsProvider = new
	 * BasicCredentialsProvider(); credsProvider.setCredentials(new
	 * AuthScope(infoArray[0], Integer.parseInt(infoArray[1])), new
	 * UsernamePasswordCredentials(infoArray[2], infoArray[3])); return
	 * HttpClients.custom().setSSLSocketFactory(socketFactory).
	 * setDefaultRequestConfig(config).setDefaultCredentialsProvider(
	 * credsProvider)
	 * .setConnectionManager(connectionManager).setConnectionManagerShared(true)
	 * .build(); } return
	 * HttpClients.custom().setSSLSocketFactory(socketFactory).
	 * setDefaultRequestConfig(config).setConnectionManagerShared(true).
	 * setConnectionManager(connectionManager).build(); } }
	 */
	@SuppressWarnings("all")
	public static CloseableHttpClient getHttpClientWithProxy(String proxyInfo, int connectTimeout, int socketTimeout) {
		String[] infoArray = proxyInfo.split(":");
		HttpHost httpHost = new HttpHost(infoArray[0], Integer.parseInt(infoArray[1]));
		RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).setProxy(httpHost)
				.setConnectTimeout(connectTimeout * 1000).setSocketTimeout(socketTimeout * 1000)
				.setConnectionRequestTimeout(socketTimeout * 1000).build();

		SSLContext sslcontext = null;
		PoolingHttpClientConnectionManager connectionManager = null;
		try {
			sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();

			connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			// 将最大连接数增加
			connectionManager.setMaxTotal(400);
			// 将每个路由基础的连接增加
			connectionManager.setDefaultMaxPerRoute(80);
			// 将目标主机的最大连接数增加
			connectionManager.setMaxPerRoute(new HttpRoute(httpHost), 200);
		} catch (Exception e) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(400);
			connectionManager.setDefaultMaxPerRoute(80);
			connectionManager.setMaxPerRoute(new HttpRoute(httpHost), 200);
		}
		if (infoArray.length == 4) {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(infoArray[0], Integer.parseInt(infoArray[1])),
					new UsernamePasswordCredentials(infoArray[2], infoArray[3]));
			return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(config)
					.setDefaultCredentialsProvider(credsProvider).setConnectionManagerShared(true).build();
		}
		return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(config)
				.setConnectionManagerShared(true).build();
	}

	/**
	 * 校验http响应是否为200
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static boolean checkResponseCodeOk(HttpResponse response) throws Exception {
		return HttpStatus.SC_OK == getResponseCode(response);
	}

	/**
	 * 获取代理host
	 * 
	 * @returnb
	 */
	private static HttpHost getProxyHost() {
		/*
		 * Proxy proxy = ProxyContext.getInstance().getProxy();
		 * LoggerUtils.info(LOGGER,"use "+proxy.toString(),"","httpClientUtil");
		 */
		return new HttpHost("10.14.60.30", 8087, "http");
	}

	/**
	 * 释放掉链接
	 * 
	 * @param context
	 */
	public static void abortHttpContex(HttpContext context) {
		context.getRequest().abort();
	}

}