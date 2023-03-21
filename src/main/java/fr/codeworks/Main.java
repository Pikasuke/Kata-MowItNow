package fr.codeworks;

import fr.codeworks.models.Remote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        if (args.length > 0) {
            Remote.mowerExecutionInstruction(args[0]);
            }
        String fileName = "src/main/resources/file.txt";
        String finalPosition = Remote.mowerExecutionInstruction(fileName);
        LOGGER.info("result   {}", finalPosition);
    }
}