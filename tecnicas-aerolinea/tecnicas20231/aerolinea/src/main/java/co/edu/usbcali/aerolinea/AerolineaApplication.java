package co.edu.usbcali.aerolinea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AerolineaApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AerolineaApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AerolineaApplication.class);
	}
}
