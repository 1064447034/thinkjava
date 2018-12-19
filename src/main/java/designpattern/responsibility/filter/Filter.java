package designpattern.responsibility.filter;

public interface Filter {
	public void doFilter(Request request, Response response, FilterChain filterChain);
}