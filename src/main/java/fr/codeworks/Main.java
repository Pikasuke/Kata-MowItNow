package fr.codeworks;

import fr.codeworks.models.Remote;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0) {
            Remote.mowerExecutionInstruction(args[0]);
            }
        String fileName = "src/main/resources/file.txt";
        Remote.mowerExecutionInstruction(fileName);
    }
}