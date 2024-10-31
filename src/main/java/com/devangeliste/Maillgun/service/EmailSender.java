package com.devangeliste.Maillgun.service;

import com.devangeliste.Maillgun.dtos.EmailDTO;

public interface EmailSender {
    void sendEmail(EmailDTO email);
}
