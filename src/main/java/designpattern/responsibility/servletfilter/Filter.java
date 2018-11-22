package designpattern.responsibility.servletfilter;

public interface Filter {
	void doFilter(Object request, Object response, FilterChain chain);
	
	void destroy();
}
