package fr.codeworks;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IntegrationTest {
    @Test
    public void testMain() throws IOException {
        System.out.println("main");
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/file.txt"));
        System.setIn(fips);
        System.setIn(original);
    }

}
