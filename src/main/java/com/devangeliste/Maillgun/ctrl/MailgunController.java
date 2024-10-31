package com.devangeliste.Maillgun.ctrl;

import com.devangeliste.Maillgun.dtos.EmailDTO;
import com.devangeliste.Maillgun.service.EmailSenderService;
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

    private final EmailSenderService service;

    @PostMapping("/send")
    ResponseEntity<String> sendMail(@RequestBody EmailDTO emailDTO) {
        service.sendEmail(emailDTO);
        return ResponseEntity.ok("Email sent successfully");
    }
}
