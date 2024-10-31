package com.devangeliste.Maillgun.service;

import com.devangeliste.Maillgun.dtos.EmailDTO;
import com.devangeliste.Maillgun.model.EmailProperties;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.nio.charset.StandardCharsets;

@Slf4j
public class SmtpEmailSender implements EmailSender{

    private final JavaMailSender mailSender;
    private final String from;

    public SmtpEmailSender(EmailProperties properties) {
        this.mailSender = properties.getMailSender();
        this.from = properties.getFrom();
    }

    @Override
    public void sendEmail(EmailDTO email) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setFrom(from);
            helper.setTo(email.to());
            helper.setSubject(email.subject());
            helper.setText(email.content(), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al generar el mensaje: %s"
                    .formatted(e.getLocalizedMessage()), e);
        } catch (MailException e) {
            throw new RuntimeException("Error al enviar el correo: %s"
                    .formatted(e.getLocalizedMessage()), e);
        }
    }

}
