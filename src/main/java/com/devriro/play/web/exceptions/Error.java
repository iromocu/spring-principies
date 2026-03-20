package com.devriro.play.web.exceptions;

public record Error(
        String type,
        String message
) {
}
