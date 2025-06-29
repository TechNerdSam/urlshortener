package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlShortenerService {

    private final UrlMappingRepository urlMappingRepository;
    private static final int SHORT_CODE_LENGTH = 7;

    // @Autowired a été supprimé ici
    public UrlShortenerService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public UrlMapping shortenUrl(String longUrl) {
        String shortCode;
        do {
            shortCode = RandomStringUtils.randomAlphanumeric(SHORT_CODE_LENGTH);
        } while (urlMappingRepository.existsByShortCode(shortCode));

        UrlMapping urlMapping = new UrlMapping(shortCode, longUrl);
        return urlMappingRepository.save(urlMapping);
    }

    public Optional<String> getLongUrl(String shortCode) {
        return urlMappingRepository.findByShortCode(shortCode)
                .map(UrlMapping::getLongUrl);
    }
}
