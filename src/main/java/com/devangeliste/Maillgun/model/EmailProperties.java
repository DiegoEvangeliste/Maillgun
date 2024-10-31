package com.devangeliste.Maillgun.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.javamail.JavaMailSender;

@Getter
@Setter
@Builder
public class EmailProperties {
    private JavaMailSender mailSender;
    private String apiKey;
    private String domain;
    private String from;
}
