package com.marcus.url_shortener.application.usecases.intefaces;

import com.marcus.url_shortener.domain.entities.url.UrlShortener;

public interface FindPath {

    UrlShortener findPath(String path);

}
