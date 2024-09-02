package com.marcus.url_shortener.infra.controller;

import com.marcus.url_shortener.application.usecases.intefaces.RedirectRequest;
import com.marcus.url_shortener.application.usecases.intefaces.SaveUrl;
import com.marcus.url_shortener.infra.dto.UrlDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Tag(name = "URL Shortener")
@RequestMapping(produces = "application/json")
public class UrlShortenerController {

    private final SaveUrl saveUrl;
    private final RedirectRequest redirectRequest;

    public UrlShortenerController(SaveUrl saveUrl, RedirectRequest redirectRequest) {
        this.saveUrl = saveUrl;
        this.redirectRequest = redirectRequest;
    }

    @PostMapping(value = "/shorten-url")
    @Operation(summary = "Encurta a URL informada pelo usuario retornando o caminho que ele deve usar para ser redirecionado", method = "POST")
    @ApiResponse(responseCode = "200", description = "URL encurtada com sucesso!")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlDTO urlDTO) {
        var response = new UrlDTO(saveUrl.save(urlDTO.url()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{path}")
    @Operation(summary = "Redireciona o usuario para a pagina correta", method = "GET")
    @ApiResponse(responseCode = "404", description = "URL informada não foi encontrada!")
    public void path(@PathVariable String path, HttpServletResponse response) throws IOException {
        redirectRequest.redirect(path, response);
    }

}
