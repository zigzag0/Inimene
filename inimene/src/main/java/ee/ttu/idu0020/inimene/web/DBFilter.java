package ee.ttu.idu0020.inimene.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class DBFilter implements Filter {

	private static final Logger log = Logger.getLogger(DBFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		DBConnection.initConnection();
		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {
			log.error(t);
			throw new ServletException(t);
		} finally {
			DBConnection.close();
		}

	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
