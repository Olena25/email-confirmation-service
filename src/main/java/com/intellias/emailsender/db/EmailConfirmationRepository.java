package com.intellias.emailsender.db;

import com.intellias.emailsender.model.EmailConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmailConfirmationRepository extends JpaRepository<EmailConfirmation,Integer> {
Optional<EmailConfirmation> findByConfirmationCode(UUID confirmationCode);
}
