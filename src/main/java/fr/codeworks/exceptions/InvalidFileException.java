package fr.codeworks.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidFileException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvalidFileException.class);

    public InvalidFileException(Exception exception) {
        super(exception);
        LOGGER.error("File loaded is not correct, please refer to the ReadMe File  message:  "  , exception);
    }


}
