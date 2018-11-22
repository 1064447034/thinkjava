package designpattern.responsibility.servletfilter;

public class Test {
	public static void main(String[] args) {
		ApplicationFilterChain applicationFilterChain = new ApplicationFilterChain();
		// 设置Filter
		ApplicationFilterConfig filterConfig = new ApplicationFilterConfig(new FirProcessFilter());
		applicationFilterChain.addFilter(filterConfig);
		filterConfig = new ApplicationFilterConfig(new SecProcessFilter());
		applicationFilterChain.addFilter(filterConfig);
		filterConfig = new ApplicationFilterConfig(new ThirdProcessFilter());
		applicationFilterChain.addFilter(filterConfig);
		
		
		String request = "request";
		String response = "resposne";
		applicationFilterChain.doFilter(request, response);
	}

}
