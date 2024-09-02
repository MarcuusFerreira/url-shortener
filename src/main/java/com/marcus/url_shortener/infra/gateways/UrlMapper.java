package com.marcus.url_shortener.infra.gateways;

import com.marcus.url_shortener.domain.entities.url.UrlShortener;
import com.marcus.url_shortener.infra.persistence.entities.UrlShortenerEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlMapper {

    public UrlShortener toDomain(UrlShortenerEntity entity) {
        return new UrlShortener(entity.getOriginalUrl(), entity.getShortenedUrl(), entity.getCreateAt(), entity.getStatus());
    }

    public UrlShortenerEntity toEntity(UrlShortener domain) {
        return new UrlShortenerEntity(domain.getOriginalUrl(), domain.getShortenedUrl(), domain.getCreateAt(), domain.getExpiredAt(), domain.getStatus());
    }

    public Map<Long, UrlShortener> toMap(List<UrlShortenerEntity> entities) {
        Map<Long, UrlShortener> map = new HashMap<>();
        entities.forEach(entity -> map.put(entity.getId(), this.toDomain(entity)));
        return map;
    }
}
