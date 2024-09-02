package com.marcus.url_shortener.application.usecases.implementation;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.application.usecases.intefaces.FindPath;
import com.marcus.url_shortener.domain.entities.url.UrlShortener;

public class FindPathImpl implements FindPath {

    private final UrlRepositoryInterface urlRepository;

    public FindPathImpl(UrlRepositoryInterface urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public UrlShortener findPath(String path) {
        return urlRepository.findByPath(path);
    }

}
