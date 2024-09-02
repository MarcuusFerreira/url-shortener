package com.marcus.url_shortener.infra.gateways;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.domain.entities.url.StatusUrl;
import com.marcus.url_shortener.domain.entities.url.UrlShortener;
import com.marcus.url_shortener.domain.exceptions.PathNotFoundException;
import com.marcus.url_shortener.infra.persistence.entities.UrlShortenerEntity;
import com.marcus.url_shortener.infra.persistence.repository.UrlRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class UrlRepositoryJpa implements UrlRepositoryInterface {

    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;

    public UrlRepositoryJpa(UrlRepository urlRepository, UrlMapper urlMapper) {
        this.urlRepository = urlRepository;
        this.urlMapper = urlMapper;
    }

    @Override
    public UrlShortener save(UrlShortener url) {
        var entity = urlMapper.toEntity(url);
        entity = urlRepository.save(entity);
        return urlMapper.toDomain(entity);
    }

    @Override
    public UrlShortener findByPath(String path) {
            var entity = urlRepository.findByShortenedUrlAndExpiredAtIsNull(path).orElseThrow(() -> new PathNotFoundException("Url not found"));
        return urlMapper.toDomain(entity);
    }

    @Override
    public void inativateUrl(Long id, UrlShortener urlShortener) {
        urlShortener.setExpiredAt(LocalDateTime.now());
        urlShortener.setStatus(StatusUrl.INACTIVE);
        var entity = urlMapper.toEntity(urlShortener);
        entity.setId(id);
        urlRepository.save(entity);
    }

    @Override
    public Map<Long, UrlShortener> findAllWhereStatusActive() {
        List<UrlShortenerEntity> entities = urlRepository.findAllByStatus(StatusUrl.ACTIVE);
        Map<Long, UrlShortener> domains = urlMapper.toMap(entities);
        return domains;
    }

    @Override
    public boolean existsByshortenedUrlAndStatus(String path, StatusUrl status) {
        return urlRepository.existsByshortenedUrlAndStatus(path, status);
    }
}
