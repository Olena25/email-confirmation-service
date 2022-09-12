package com.intellias.emailsender.service;

import com.intellias.emailsender.db.EmailConfirmationRepository;
import com.intellias.emailsender.db.UserRepository;
import com.intellias.emailsender.exception.EmailConfirmationNotFoundException;
import com.intellias.emailsender.exception.UserNotFoundException;
import com.intellias.emailsender.model.EmailConfirmation;
import com.intellias.emailsender.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EmailConfirmationService {

    private UserRepository userRepository;
    private EmailSenderService emailSenderService;
    private EmailConfirmationRepository emailConfirmationRepository;

    public void createAndSendEmailConfirmation(int userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        EmailConfirmation emailConfirmation = EmailConfirmation.builder()
                .user(user)
                .confirmationCode(UUID.randomUUID())
                .build();

        emailConfirmationRepository.save(emailConfirmation);

        emailSenderService.sendEmailToUser(user.getEmail(), emailConfirmation.getConfirmationCode());
    }

    public void confirmEmail(UUID confirmationCode) {

        EmailConfirmation emailConfirmation =
                emailConfirmationRepository.findByConfirmationCode(confirmationCode)
                        .orElseThrow(EmailConfirmationNotFoundException::new);

        User user = emailConfirmation.getUser();
        user.setEmailConfirmed(true);
        userRepository.save(user);

    }
}

