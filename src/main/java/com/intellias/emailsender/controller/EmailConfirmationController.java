package com.intellias.emailsender.controller;

import com.intellias.emailsender.dto.ConfirmationSuccessResponse;
import com.intellias.emailsender.service.EmailConfirmationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor

public class EmailConfirmationController {
    private EmailConfirmationService emailConfirmationService;

    @PostMapping("/emails/send/confirmation/{userId}")
    public void createAndSendEmailConfirmation(@PathVariable int userId) {
        emailConfirmationService.createAndSendEmailConfirmation(userId);
    }

    @GetMapping("/emails/confirm/{confirmationCode}")
    public ConfirmationSuccessResponse confirmEmail(@PathVariable UUID confirmationCode){
        emailConfirmationService.confirmEmail(confirmationCode);

        return new ConfirmationSuccessResponse("Email successfully confirmed");
    }
}
