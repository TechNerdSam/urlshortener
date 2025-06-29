package com.example.urlshortener.controller;

import com.example.urlshortener.dto.ShortenUrlRequest;
import com.example.urlshortener.dto.ShortenUrlResponse;
import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.service.UrlShortenerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
// Ajoutez cette ligne pour autoriser les requêtes de toutes les origines
@CrossOrigin(origins = "*") 
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;
    private final String baseUrl;

    public UrlShortenerController(UrlShortenerService urlShortenerService, @Value("${app.base-url}") String baseUrl) {
        this.urlShortenerService = urlShortenerService;
        this.baseUrl = baseUrl;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@Valid @RequestBody ShortenUrlRequest request) {
        UrlMapping urlMapping = urlShortenerService.shortenUrl(request.getLongUrl());
        
        String shortUrl = baseUrl + "/" + urlMapping.getShortCode(); // J'ai ajouté un "/" ici pour être sûr
        
        ShortenUrlResponse response = new ShortenUrlResponse(shortUrl, urlMapping.getLongUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirectToLongUrl(@PathVariable String shortCode) {
        return urlShortenerService.getLongUrl(shortCode)
                .map(longUrl -> {
                    String urlToRedirect = longUrl;
                    if (!urlToRedirect.toLowerCase().startsWith("http://") && !urlToRedirect.toLowerCase().startsWith("https://")) {
                        urlToRedirect = "http://" + urlToRedirect;
                    }
                    
                    HttpHeaders headers = new HttpHeaders();
                    try {
                        headers.setLocation(new URI(urlToRedirect));
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                    return new ResponseEntity<>(headers, HttpStatus.FOUND);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}