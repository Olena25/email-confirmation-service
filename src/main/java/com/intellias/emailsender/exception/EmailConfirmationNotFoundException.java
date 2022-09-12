package com.intellias.emailsender.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Email confirmation code not found")
public class EmailConfirmationNotFoundException extends RuntimeException{

}
