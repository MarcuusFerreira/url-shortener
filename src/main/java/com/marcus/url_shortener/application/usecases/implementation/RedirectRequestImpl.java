package com.marcus.url_shortener.application.usecases.implementation;

import com.marcus.url_shortener.application.usecases.intefaces.FindPath;
import com.marcus.url_shortener.application.usecases.intefaces.RedirectRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RedirectRequestImpl implements RedirectRequest {

    private final FindPath findPath;

    public RedirectRequestImpl(FindPath findPath) {
        this.findPath = findPath;
    }

    @Override
    public void redirect(String url, HttpServletResponse response) throws IOException {
        var domain = findPath.findPath(url);
        response.sendRedirect(domain.getOriginalUrl());
    }

}
