package org.singledog.dogmall.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Spring cloud gateway advisor
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@RefreshScope
@Configuration(proxyBeanMethods = false)
public class GatewayConfiguration {

    @Value("${cors.origins}")
    private List<String> origins;

    @Value("${cors.headers}")
    private List<String> headers;

    @Value("${cors.methods}")
    private List<String> methods;

    /**
     * Configure cross domain
     */
    @Bean
    public CorsWebFilter registerCorsFilter() {
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(origins);
        corsConfiguration.setAllowedHeaders(headers);
        corsConfiguration.setAllowedMethods(methods);
        corsConfiguration.setAllowCredentials(true);
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(corsConfigurationSource);
    }
}
