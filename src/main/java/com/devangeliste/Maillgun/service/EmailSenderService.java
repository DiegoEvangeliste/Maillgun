package com.devangeliste.Maillgun.service;

import com.devangeliste.Maillgun.dtos.EmailDTO;
import com.devangeliste.Maillgun.enums.TipoEnvioEnum;
import com.devangeliste.Maillgun.model.EmailProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@Slf4j
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${email.sender.option}")
    private String emailSenderOption;

    @Value("${mailgun.api.key}")
    private String apiKey;

    @Value("${mailgun.domain}")
    private String domain;

    @Value("${email.from}")
    private String from;

    public void sendEmail(EmailDTO emailDTO) {
        EmailProperties properties = EmailProperties.builder()
                .mailSender(mailSender)
                .apiKey(apiKey)
                .domain(domain)
                .from(from)
                .build();

        EmailSenderFactory factory = new EmailSenderFactory(properties);
        EmailSender emailSender = factory.getSender(TipoEnvioEnum.valueOf(emailSenderOption));

        emailSender.sendEmail(emailDTO);
    }
}
