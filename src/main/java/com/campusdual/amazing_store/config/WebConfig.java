package com.campusdual.amazing_store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Configuration class for enabling Cross-Origin Resource Sharing (CORS).
 * This configuration allows cross-origin requests from specified origins,
 * enhancing the security and flexibility of the application's API endpoints.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Adds CORS mappings to allow cross-origin requests.
     * This method specifies which origins are allowed to access the application resources,
     * which HTTP methods are permitted, which headers can be sent, and whether credentials are supported.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("*")  // Permitir todas las solicitudes de origen
                .allowedOrigins("https://amazing-store-front-javascript-angular-full.vercel.app/", "http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

