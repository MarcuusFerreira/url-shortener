package com.marcus.url_shortener.application.usecases.intefaces;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface RedirectRequest {

    void redirect(String url, HttpServletResponse response) throws IOException;

}
