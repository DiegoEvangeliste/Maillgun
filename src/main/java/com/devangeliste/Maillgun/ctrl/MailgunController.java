package com.devangeliste.Maillgun.ctrl;

import com.devangeliste.Maillgun.dtos.EmailDTO;
import com.devangeliste.Maillgun.service.MailgunService;
import com.mailgun.model.message.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mailgun")
@RequiredArgsConstructor
public class MailgunController {

    private final MailgunService service;

    @PostMapping("/send")
    ResponseEntity<MessageResponse> sendMail(@RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(service.sendEmail(emailDTO));
    }
}
