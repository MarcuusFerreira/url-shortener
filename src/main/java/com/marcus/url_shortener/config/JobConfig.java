package com.marcus.url_shortener.config;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.application.usecases.implementation.InativateUrlImpl;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;

@Configuration
public class JobConfig {

    private final UrlRepositoryInterface urlRepository;

    public JobConfig(UrlRepositoryInterface urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Bean
    public ApplicationRunner jobInativateUrl() {
        return args -> {
            Timer timer = new Timer();
            InativateUrlImpl inativateUrl = new InativateUrlImpl(timer, urlRepository);
            Long delay = 300000L;
            Long interval = 300000L;
            inativateUrl.inativate(delay, interval);
        };
    }
}
