package com.marcus.url_shortener.domain.entities.url;

import java.time.LocalDateTime;

public class UrlBuilder {

    public UrlShortener createWithUrlAndPath(String url, String path) {
        return new UrlShortener(url, path, LocalDateTime.now(), StatusUrl.ACTIVE);
    }

}
