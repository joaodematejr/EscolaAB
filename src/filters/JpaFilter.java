package filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import commons.JpaUtil;

@WebFilter(servletNames = "Faces Servet")
public class JpaFilter implements Filter {

	@Override
	public void destroy() {
		JpaUtil.init();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		EntityManager entityManager = JpaUtil.createEntityManager(request);
		entityManager.getTransaction().begin();
		filterChain.doFilter(request, response);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		JpaUtil.destroy();

	}

}
