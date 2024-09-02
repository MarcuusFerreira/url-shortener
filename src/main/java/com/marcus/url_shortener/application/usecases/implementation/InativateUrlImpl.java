package com.marcus.url_shortener.application.usecases.implementation;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.application.usecases.intefaces.InativateUrl;
import com.marcus.url_shortener.domain.entities.url.UrlShortener;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class InativateUrlImpl implements InativateUrl {

    private final Timer timer;
    private final UrlRepositoryInterface urlRepository;
    private final static int EXPIRES_IN_HOURS = 1;

    public InativateUrlImpl(Timer timer, UrlRepositoryInterface urlRepository) {
        this.timer = timer;
        this.urlRepository = urlRepository;
    }

    @Override
        public void inativate(Long delay, Long interval) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                var pathList = findUrlToInative();
                System.out.println("Rodando o job");
                pathList.forEach((id, url) -> {
                    if (expiresUrl(url)) urlRepository.inativateUrl(id, url);
                });
            }
        };
        timer.scheduleAtFixedRate(task, delay, interval);
    }

    private Map<Long, UrlShortener> findUrlToInative() {
        return urlRepository.findAllWhereStatusActive();
    }

    private boolean expiresUrl(UrlShortener urlShortener) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(urlShortener.getCreateAt(), now);
        return duration.toHours() >= EXPIRES_IN_HOURS;
    }
}
