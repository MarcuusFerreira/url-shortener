package com.marcus.url_shortener.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public record RestErrorMessage(
        @JsonProperty("http_status")
        HttpStatus httpStatus,
        String message
) {
}
