package designpattern.responsibility.servletfilter;

import java.util.Objects;

import javax.servlet.Servlet;

public class ApplicationFilterChain implements FilterChain {
	private int pos = 0;

	private int n = 0;

	private Servlet servlet;

	private ApplicationFilterConfig[] filters = new ApplicationFilterConfig[0];

	public static final int INCREMENT = 10;

	@Override
	public void doFilter(Object request, Object response) {
		internalDoFilter(request, response);
	}

	public void internalDoFilter(Object request, Object response) {
		if (pos < n) {
			ApplicationFilterConfig filterConfig = filters[pos++];
			Filter filter = filterConfig.getFilter();
			filter.doFilter(request, response, this);
			return;
		}
//		servlet.service(request, response);
	}

	public void addFilter(ApplicationFilterConfig filterConfig) {
		for (int i = 0; i < filters.length; i++) {
			if (Objects.equals(filters[i], filterConfig)) {
				return;
			}
		}

		if (n == filters.length) {
			ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n + INCREMENT];
			System.arraycopy(filters, 0, newFilters, 0, n);
			filters = newFilters;
		}
		filters[n++] = filterConfig;
	}

	public void setServlet(Servlet servlet) {
		this.servlet = servlet;
	}

	public void release() {
		for (int i = 0; i < n; i++) {
			filters[i] = null;
		}
		n = 0;
		pos = 0;
		servlet = null;
	}

}
