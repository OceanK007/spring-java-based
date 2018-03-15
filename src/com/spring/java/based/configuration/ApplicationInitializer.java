package com.spring.java.based.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/** To initialize the application **/
/** Replacement of: web.xml **/
public class ApplicationInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException 
	{
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ApplicationConfiguration.class);
		ctx.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}

/** Now you can write the above class even more concisely [and it’s the preferred way], 
by extending AbstractAnnotationConfigDispatcherServletInitializer base class **/
/*public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[] {ApplicationConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"};
	}
}*/