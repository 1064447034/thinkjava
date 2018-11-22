package designpattern.responsibility.servletfilter;

public class SecProcessFilter implements Filter {

	@Override
	public void doFilter(Object request, Object response, FilterChain chain) {
		System.out.println("SecProcessFilter: " + request);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
