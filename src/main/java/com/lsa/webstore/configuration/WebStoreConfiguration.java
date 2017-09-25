package com.lsa.webstore.configuration;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

@EnableWebMvc
@ComponentScan(basePackages = { "com.lsa.webstore" })
@Configuration
/*
 * @EnableJpaRepositories(basePackageClasses = { ProductRepositoryImpl.class,
 * ProductRepository.class })
 */

public class WebStoreConfiguration extends WebMvcConfigurerAdapter {
	private static ServletContext ctx;

	public void setServletContext(ServletContext servletContext) {
		this.ctx = servletContext;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setCache(true);
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		MutablePropertySources propertySources = new MutablePropertySources();
		
		Resource resourceYaml = new DefaultResourceLoader().getResource("file:./config/app.yml");
		YamlPropertySourceLoader sourceYamlLoader = new YamlPropertySourceLoader();
		PropertySource<?> yamlProperties = sourceYamlLoader.load("resourceYaml", resourceYaml, null);
		propertySources.addFirst(yamlProperties);
		
		//configurer.setIgnoreUnresolvablePlaceholders(true);
		configurer.setPropertySources(propertySources);
		return configurer;
	}

}
