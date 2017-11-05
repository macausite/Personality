package com.robotable.personality.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.robotable.personality")
public class PersonalityConfiguration implements WebMvcConfigurer {

 
	@Autowired
	  ApplicationContext applicationContext;
	  
	  @Bean
	  public SpringTemplateEngine templateEngine(){
	      SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	      templateEngine.setTemplateResolver(templateResolver());
	      return templateEngine;
	  }
	  
	  @Bean
	  public SpringResourceTemplateResolver templateResolver(){
	      SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	      templateResolver.setApplicationContext(this.applicationContext);
	      templateResolver.setPrefix("/WEB-INF/views/");
	      templateResolver.setSuffix(".html");
	      return templateResolver;
	  }
	  
	  @Bean
	  public ViewResolver viewResolver(){
	      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	      viewResolver.setTemplateEngine(templateEngine());
	   
	      viewResolver.setOrder(1);
	        //viewResolver.setViewNames(new String[]{"templates/*"});
	      return viewResolver;
	  }
	  
		@Bean
	    public ViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        viewResolver.setOrder(2);
	         
	        return viewResolver;
	    }
	    
	@Override
	    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	    }
	    
}