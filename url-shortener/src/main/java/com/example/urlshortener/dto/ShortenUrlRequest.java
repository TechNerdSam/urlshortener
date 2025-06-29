package com.example.urlshortener.dto;

import lombok.Data;

@Data
public class ShortenUrlRequest {
    private String longUrl;
}