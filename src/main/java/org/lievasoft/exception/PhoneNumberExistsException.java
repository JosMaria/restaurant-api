package org.lievasoft.exception;

public class PhoneNumberExistsException extends RuntimeException {

    public PhoneNumberExistsException(String phoneNumber) {
        super("Phone number: %s already exists".formatted(phoneNumber));
    }
}
