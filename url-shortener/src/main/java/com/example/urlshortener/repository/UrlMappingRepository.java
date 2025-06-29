package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    // Méthode pour trouver une URL par son code court
    Optional<UrlMapping> findByShortCode(String shortCode);

    // Méthode pour vérifier si un code court existe
    boolean existsByShortCode(String shortCode);
}