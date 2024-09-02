package com.marcus.url_shortener.config;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.application.usecases.implementation.*;
import com.marcus.url_shortener.application.usecases.intefaces.*;
import com.marcus.url_shortener.domain.entities.url.UrlBuilder;
import com.marcus.url_shortener.infra.gateways.UrlMapper;
import com.marcus.url_shortener.infra.gateways.UrlRepositoryJpa;
import com.marcus.url_shortener.infra.persistence.repository.UrlRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public SaveUrl saveUrl(UrlRepositoryInterface urlRepository, ShortenUrl shortenUrl, UrlBuilder urlBuilder) {
        return new SaveUrlImpl(urlRepository, shortenUrl, urlBuilder);
    }

    @Bean
    public UrlRepositoryInterface urlRepositoryInterface(UrlRepository urlRepository, UrlMapper urlMapper) {
        return new UrlRepositoryJpa(urlRepository, urlMapper);
    }

    @Bean
    public ShortenUrl shortenUrl(UrlRepositoryInterface urlRepository) {
        return new ShortenUrlImpl(urlRepository);
    }

    @Bean
    public UrlMapper urlMapper() {
        return new UrlMapper();
    }

    @Bean
    public UrlBuilder urlBuilder() {
        return new UrlBuilder();
    }

    @Bean
    public RedirectRequest redirectRequest(FindPath findPath) {
        return new RedirectRequestImpl(findPath);
    }

    @Bean
    public FindPath findPath(UrlRepositoryInterface urlRepository) {
        return new FindPathImpl(urlRepository);
    }

    @Bean
    public Timer timer() {
        return new Timer();
    }

    @Bean
    public InativateUrl inativateUrl(UrlRepositoryInterface urlRepository, Timer timer) {
        return new InativateUrlImpl(timer, urlRepository);
    }

}
