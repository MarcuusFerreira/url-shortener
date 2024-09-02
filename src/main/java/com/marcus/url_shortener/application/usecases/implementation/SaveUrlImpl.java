package com.marcus.url_shortener.application.usecases.implementation;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.application.usecases.intefaces.SaveUrl;
import com.marcus.url_shortener.application.usecases.intefaces.ShortenUrl;
import com.marcus.url_shortener.domain.entities.url.UrlBuilder;

public class SaveUrlImpl implements SaveUrl {

    private final UrlRepositoryInterface urlRepository;
    private final ShortenUrl shortenUrl;
    private final UrlBuilder urlBuilder;

    public SaveUrlImpl(UrlRepositoryInterface urlRepository, ShortenUrl shortenUrl, UrlBuilder urlBuilder) {
        this.urlRepository = urlRepository;
        this.shortenUrl = shortenUrl;
        this.urlBuilder = urlBuilder;
    }

    @Override
    public String save(String url) {
        var path = shortenUrl.shortenUrl();
        var domain = urlBuilder.createWithUrlAndPath(url, path);
        return urlRepository.save(domain).getShortenedUrl();
    }

}
