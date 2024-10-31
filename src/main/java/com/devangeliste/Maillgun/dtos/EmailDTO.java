package com.devangeliste.Maillgun.dtos;

public record EmailDTO(
        String to,
        String content,
        String subject) {
}
