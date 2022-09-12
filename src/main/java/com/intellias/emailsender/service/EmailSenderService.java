package com.intellias.emailsender.service;

import com.intellias.emailsender.config.CarRentalProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private static final String URL_SCHEME = "http";

    @Value("${server.port}")
    private int port;

    private final CarRentalProperties carRentalProperties;
    private final JavaMailSender mailSender;

    public void sendEmailToUser(String userEmail, UUID confirmationCode) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(URL_SCHEME)
                .host(carRentalProperties.getHost())
                .port(port)
                .path(carRentalProperties.getEndpoint().getConfirmation())
                .pathSegment(confirmationCode.toString())
                .build();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setFrom(carRentalProperties.getFromEmail());
        message.setSubject("Car rental email confirmation");
        message.setText("To confirm your email please follow the link : " + uriComponents);
        mailSender.send(message);
    }
}
