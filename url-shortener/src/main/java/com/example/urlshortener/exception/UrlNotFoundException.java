package com.example.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception personnalisée levée lorsqu'une URL courte demandée n'est pas trouvée dans la base de données.
 * L'annotation @ResponseStatus indique à Spring de retourner un code de statut HTTP 404 (Not Found)
 * lorsque cette exception est levée par un contrôleur.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlNotFoundException extends RuntimeException {

    /**
     * Constructeur qui accepte un message détaillant la raison de l'exception.
     * @param message Le message d'erreur.
     */
    public UrlNotFoundException(String message) {
        super(message);
    }
}
