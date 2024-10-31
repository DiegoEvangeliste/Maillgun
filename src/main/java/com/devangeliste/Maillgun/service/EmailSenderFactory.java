package com.devangeliste.Maillgun.service;

import com.devangeliste.Maillgun.enums.TipoEnvioEnum;
import com.devangeliste.Maillgun.model.EmailProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.devangeliste.Maillgun.enums.TipoEnvioEnum.MAILGUN;
import static com.devangeliste.Maillgun.enums.TipoEnvioEnum.SMTP;

@Slf4j
public class EmailSenderFactory {

    private final Map<TipoEnvioEnum, EmailSender> senders = new HashMap<>();

    public EmailSenderFactory(EmailProperties properties) {
        senders.put(SMTP, new SmtpEmailSender(properties));
        senders.put(MAILGUN, new MailgunEmailSender(properties));
    }

    public EmailSender getSender(TipoEnvioEnum tipoEnvio) {
        return senders.get(tipoEnvio);
    }

}
