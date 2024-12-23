package com.gazi.lostFound.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // Make sure this matches your frontend URL
                .allowedOrigins("http://localhost:3000")
                //allow all these methods
                .allowedMethods("GET", "POST", "PUT", "DELETE")

                .allowedHeaders("*")
                .allowCredentials(true);  // allow cookies and credential headers etc
    }
}
