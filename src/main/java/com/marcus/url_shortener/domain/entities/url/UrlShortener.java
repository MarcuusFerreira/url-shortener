package com.marcus.url_shortener.domain.entities.url;

import java.time.LocalDateTime;

public class UrlShortener {

    private String originalUrl;
    private String shortenedUrl;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;
    private StatusUrl status;

    public UrlShortener(String originalUrl, String shortenedUrl, LocalDateTime createAt, StatusUrl status) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.createAt = createAt;
        this.status = status;
    }

    public UrlShortener() {
        super();
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
