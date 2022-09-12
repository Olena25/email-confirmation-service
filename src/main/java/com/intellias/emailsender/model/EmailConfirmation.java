package com.intellias.emailsender.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "email_confirmation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private User user;
    @Column(name = "confirmation_code")
    @Type(type = "uuid-char")
    private UUID confirmationCode;
}
