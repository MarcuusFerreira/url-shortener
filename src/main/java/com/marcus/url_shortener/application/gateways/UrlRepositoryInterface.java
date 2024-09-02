package com.marcus.url_shortener.application.gateways;

import com.marcus.url_shortener.domain.entities.url.StatusUrl;
import com.marcus.url_shortener.domain.entities.url.UrlShortener;

import java.util.List;
import java.util.Map;

public interface UrlRepositoryInterface {

    UrlShortener save(UrlShortener url);

    UrlShortener findByPath(String path);

    void inativateUrl(Long id, UrlShortener urlShortener);

    Map<Long, UrlShortener> findAllWhereStatusActive();

    boolean existsByshortenedUrlAndStatus(String shortenedUrl, StatusUrl statusUrl);

}
