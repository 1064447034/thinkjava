package designpattern.responsibility.servletfilter;

import javax.servlet.Servlet;

public class ApplicationFilterFactory {
	/**
	 * 创建过滤器链，每个请求都会调用
	 * 
	 * @param request
	 * @param wrapper
	 * @param servlet
	 */
	public static ApplicationFilterChain createFilterChain(Object request, Object wrapper, Servlet servlet) {

		ApplicationFilterChain applicationFilterChain = new ApplicationFilterChain();
		// 设置Filter
		ApplicationFilterConfig filterConfig = new ApplicationFilterConfig(new FirProcessFilter());
		applicationFilterChain.addFilter(filterConfig);
		filterConfig = new ApplicationFilterConfig(new SecProcessFilter());
		applicationFilterChain.addFilter(filterConfig);
		return applicationFilterChain;
	}

}
