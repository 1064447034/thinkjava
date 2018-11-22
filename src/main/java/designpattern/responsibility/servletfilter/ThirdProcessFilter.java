package designpattern.responsibility.servletfilter;

public class ThirdProcessFilter implements Filter {

	@Override
	public void doFilter(Object request, Object response, FilterChain chain) {
		System.out.println("ThirdProcessFilter: " + request);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
