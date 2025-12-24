package org.lievasoft.exception;

public class WaiterNotFoundException extends RuntimeException {

    public WaiterNotFoundException(String waiterId) {
        super("Waiter with ID: '%s' not found".formatted(waiterId));
    }
}
