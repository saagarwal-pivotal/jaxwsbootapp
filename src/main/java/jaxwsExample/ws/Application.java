package jaxwsExample.ws;


import com.sun.xml.ws.transport.http.servlet.WSServlet;
import com.sun.xml.ws.transport.http.servlet.WSServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextListener;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	// Register ServletContextListener
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
		ServletListenerRegistrationBean<ServletContextListener> bean =
				new ServletListenerRegistrationBean<>();
		bean.setListener(new ContextLoaderListener());
		bean.setListener(new WSServletContextListener());
		return bean;

	}
	@Bean
	public ServletRegistrationBean wsServlet(){
		return new ServletRegistrationBean(new WSServlet(), "/HelloWs");

	}


}