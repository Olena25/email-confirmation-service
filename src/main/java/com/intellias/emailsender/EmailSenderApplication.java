package com.intellias.emailsender;

import com.intellias.emailsender.config.CarRentalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CarRentalProperties.class)
public class EmailSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }
}

