package com.marcus.url_shortener.infra.persistence.entities;

import com.marcus.url_shortener.domain.entities.url.StatusUrl;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity(name = "url_table")
public class UrlShortenerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortenedUrl;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;
    @Enumerated(EnumType.STRING)
    private StatusUrl status;

    public UrlShortenerEntity(String originalUrl, String shortenedUrl, LocalDateTime createAt, LocalDateTime expiredAt, StatusUrl status) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.createAt = createAt;
        this.expiredAt = expiredAt;
        this.status = status;
    }

    public UrlShortenerEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public StatusUrl getStatus() {
        return status;
    }

    public void setStatus(StatusUrl status) {
        this.status = status;
    }
}
