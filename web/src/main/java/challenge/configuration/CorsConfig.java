package challenge.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase encargada de definir las politicas de Cors
 *
 * @author Ezequiel Cristeche
 * @since 06/9/2020
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry
	                .addMapping("/**")
	                .allowedOrigins("*")
	                .allowedHeaders("*")
	                .allowedMethods("*")
	                .allowCredentials(true);
	    }
}