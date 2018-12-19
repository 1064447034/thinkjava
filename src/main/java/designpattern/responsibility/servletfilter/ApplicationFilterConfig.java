package designpattern.responsibility.servletfilter;

public class ApplicationFilterConfig {
	private Filter filter;

	public ApplicationFilterConfig(Filter filter) {
		this.filter = filter;
	}

	public Filter getFilter() {
		return filter;
	}
}
