package org.o7planning.springmvcshoppingcart.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

public class SpringWebAppInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationContextConfiguration.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);
		servletContext.addListener(contextLoaderListener);
		
		//Filter
		FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		fr.setInitParameter("encoding", "utf-8");
		fr.addMappingForUrlPatterns(null, true, "/*");
	}

}
