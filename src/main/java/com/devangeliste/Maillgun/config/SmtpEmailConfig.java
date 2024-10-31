package com.devangeliste.Maillgun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class SmtpEmailConfig {

    @Value("${smtp.host}")
    private String host;

    @Value("${smtp.port}")
    private int port;

    @Value("${email.from}")
    private String emailUser;

    @Value("${smtp.password}")
    private String passwordEmailUser;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender  = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(emailUser);
        mailSender.setPassword(passwordEmailUser);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
