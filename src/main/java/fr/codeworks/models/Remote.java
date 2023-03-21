package fr.codeworks.models;

import fr.codeworks.enums.Cardinals;
import fr.codeworks.exceptions.InvalidFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Remote {
    private static final Logger LOGGER = LoggerFactory.getLogger(Remote.class);
    private Remote() {
    }

    public static Mower createMower(String parameters) {
        try {
            int xMowerParameter = Integer.parseInt(String.valueOf(parameters.charAt(0)));
            int yMowerParameter = Integer.parseInt(String.valueOf(parameters.charAt(2)));
            Cardinals orientationMowerParameter = Cardinals.valueOf(String.valueOf(parameters.charAt(parameters.length()-1)));
            Mower mower = new Mower();
            mower.setX(xMowerParameter);
            mower.setY(yMowerParameter);
            mower.setOrientation(orientationMowerParameter);
            return mower;
        } catch (Exception e) {
            LOGGER.error("Create Mower failed");
            throw new InvalidFileException(e);
        }
    }

    public static String sendPosition(Mower mower) {
        return String.valueOf(mower.getX())+ " " + String.valueOf(mower.getY()) + " " + mower.getOrientation().toString()+ " ";
    }

    public static Garden createGarden(List<String> instruction) {
        String[] field = instruction.get(0).split(" ");
        try {
            return new Garden(Integer.parseInt(field[0]), Integer.parseInt(field[field.length-1]));
        }  catch (Exception e) {
            LOGGER.error("Create garden failed");
            throw new InvalidFileException(e);
        }
    }

    public static List<String> loadInstruction(String fileName) {
        try {
            Path pathFile = Paths.get(fileName);
            Files.exists(pathFile);
            Files.isRegularFile(pathFile);
            return Files.readAllLines(pathFile);
        } catch (Exception e) {
            LOGGER.error("Load instruction failed");
            throw new InvalidFileException(e);
        }
    }

    public static void mowerExecutionInstruction(String fileName) {
        List<String> instructionFiles = Remote.loadInstruction(fileName);
        LOGGER.info("instruction Files  {}", instructionFiles);

        Garden garden = Remote.createGarden(instructionFiles);
        String mowersFinalPosition = "";
        Mower mower = new Mower();
        for (int i = 1; i < instructionFiles.size() ; i++) {
            boolean isMower = i % 2 == 1;
            if (isMower) {
                mower = Remote.createMower(instructionFiles.get(i));
                mower.setGarden(garden);
            }
            boolean isInstruction = i % 2 == 0;
            if (isInstruction) {
                String instruction = instructionFiles.get(i);
                mower.execute(instruction);
                mowersFinalPosition = mowersFinalPosition + Remote.sendPosition(mower);
            }
        }
        LOGGER.info("result   {}", mowersFinalPosition);
    }

}