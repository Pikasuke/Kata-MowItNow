package fr.codeworks;

import fr.codeworks.models.Remote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IntegrationTest {
    @Test
    public void testMain() throws IOException {
        Assertions.assertEquals("1 3 N 5 1 E", Remote.mowerExecutionInstruction("src/main/resources/file.txt"));


    }

}
