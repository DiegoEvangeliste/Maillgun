package com.devangeliste.Maillgun.service;

import com.devangeliste.Maillgun.dtos.EmailDTO;
import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailgunService {

    private final MailgunMessagesApi mailgunMessagesApi;
    private final String domain;
    private final String from;

    public MailgunService(
            @Value("${mailgun.api.key}") String apiKey,
            @Value("${mailgun.domain}") String domain,
            @Value("${mailgun.from}") String from) {

        this.mailgunMessagesApi = MailgunClient.config(apiKey).createApi(MailgunMessagesApi.class);
        this.domain = domain;
        this.from = from;
    }

    public MessageResponse sendEmail(EmailDTO emailDTO) {
        Message message = Message.builder()
                .from(from)
                .to(emailDTO.to())
                .subject(emailDTO.subject())
                .text(emailDTO.text())
                .build();

        MessageResponse messageResponse = mailgunMessagesApi.sendMessage(domain, message);

        if (messageResponse == null) {
            throw new RuntimeException("Error sending email");
        }

        return messageResponse;
    }

}
