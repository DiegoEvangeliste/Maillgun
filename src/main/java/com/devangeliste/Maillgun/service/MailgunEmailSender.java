package com.devangeliste.Maillgun.service;

import com.devangeliste.Maillgun.dtos.EmailDTO;
import com.devangeliste.Maillgun.model.EmailProperties;
import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailgunEmailSender implements EmailSender{

    private final MailgunMessagesApi mailgunMessagesApi;
    private final String domain;
    private final String from;

    public MailgunEmailSender(EmailProperties properties) {
        this.mailgunMessagesApi = MailgunClient
                .config(properties.getApiKey()).createApi(MailgunMessagesApi.class);
        this.domain = properties.getDomain();
        this.from = properties.getFrom();
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        Message message = Message.builder()
                .from(from)
                .to(emailDTO.to())
                .subject(emailDTO.subject())
                .text(emailDTO.content())
                .build();

        MessageResponse messageResponse = mailgunMessagesApi.sendMessage(domain, message);

        if (messageResponse == null) {
            throw new RuntimeException("Error sending email");
        }
    }

}
