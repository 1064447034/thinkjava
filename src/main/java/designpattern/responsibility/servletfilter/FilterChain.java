package designpattern.responsibility.servletfilter;

public interface FilterChain {
	void doFilter(Object request, Object response);
	
}
