package com.marcus.url_shortener.domain.exceptions;

public class PathNotFoundException extends BusinessException {

    public PathNotFoundException(String message) {
        super(message);
    }

}
