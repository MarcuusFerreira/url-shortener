package com.marcus.url_shortener.infra.persistence.repository;

import com.marcus.url_shortener.domain.entities.url.StatusUrl;
import com.marcus.url_shortener.infra.persistence.entities.UrlShortenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlShortenerEntity, Long> {

    Optional<UrlShortenerEntity> findByShortenedUrlAndExpiredAtIsNull(String shortUrl);

    List<UrlShortenerEntity> findAllByStatus(StatusUrl status);

    boolean existsByshortenedUrlAndStatus(String shortenedUrl, StatusUrl status);
}
