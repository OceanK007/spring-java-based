package com.spring.java.based.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/** To create beans **/

@Configuration								/** Replacement of: spring-servlet.xml **/
@EnableWebMvc								/** Equivalent to: <mvc:annotation-driven/> **/
@ComponentScan(basePackages="com.spring")	/** Equivalent to: <context:component-scan base-package="com.spring" /> **/
public class ApplicationConfiguration extends WebMvcConfigurerAdapter
{
	/**There must be always be a default constructor else application won't start.
	So always provide a default constructor if you are providing a parameterized constructor **/
	/*public ApplicationConfiguration(String s){}
	public ApplicationConfiguration() {}*/
	
	/** Equivalent to: <mvc:resources location="/WEB-INF/" mapping="/static/**"/> **/
	/*@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/");
	}*/
	
	
	/** Equivalent to:
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/"/>
		<property name="suffix" value=".jsp"/>
	</bean>
	**/
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
