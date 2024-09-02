package com.marcus.url_shortener.application.usecases.implementation;

import com.marcus.url_shortener.application.gateways.UrlRepositoryInterface;
import com.marcus.url_shortener.application.usecases.intefaces.ShortenUrl;
import com.marcus.url_shortener.domain.entities.url.StatusUrl;

import java.util.Random;

public class ShortenUrlImpl implements ShortenUrl {

    private final static Integer MAX_SIZE_SHORTENER = 11;
    private final static Integer MIN_SIZE_SHORTENER = 5;
    private final static String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final UrlRepositoryInterface urlRepository;

    public ShortenUrlImpl(UrlRepositoryInterface urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public String shortenUrl() {
        int length = this.generateNumber();
        var path = this.generatePath(length);
        while (urlRepository.existsByshortenedUrlAndStatus(path, StatusUrl.ACTIVE)) {
            path = this.generatePath(length);
        }
        return path;
    }

    private int isLessThanFive(int length) {
        if (length < MIN_SIZE_SHORTENER) return MIN_SIZE_SHORTENER;
        return length;
    }

    private int generateNumber() {
        var length = new Random().nextInt(MAX_SIZE_SHORTENER);
        length = isLessThanFive(length);
        return length;
    }

    private String generatePath(int length) {
        var random = new Random();
        var path = new StringBuilder();
        for (int i =0; i < length; i++) {
            path.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return path.toString();
    }
}
