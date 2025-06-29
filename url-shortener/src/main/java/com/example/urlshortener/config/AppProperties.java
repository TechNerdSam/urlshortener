package com.example.urlshortener.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// L'annotation @ConfigurationProperties lie cette classe aux propriétés préfixées par "app"
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    // Exemple de propriété personnalisée
    private String baseUrl;

    // Getters et Setters sont nécessaires pour que Spring Boot puisse injecter les valeurs
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}