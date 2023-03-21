package fr.codeworks.exceptions;

import fr.codeworks.models.Remote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidFileException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(Remote.class);

    public InvalidFileException(Exception message) {
        super();
        LOGGER.error("File loaded is not correct, please reffer to the ReadMe File  message:  " + message);
    }


}
