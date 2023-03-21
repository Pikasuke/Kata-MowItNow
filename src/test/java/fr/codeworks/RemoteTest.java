package fr.codeworks;

import fr.codeworks.models.Garden;
import fr.codeworks.models.Mower;
import fr.codeworks.enums.Cardinals;
import fr.codeworks.models.Remote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RemoteTest {

    @Test
    public void givenAStringToCreateNewMower() {
        Mower mower = Remote.createMower("1 1 N");
        Assertions.assertEquals(1, mower.getX());
        Assertions.assertEquals(1, mower.getY());
        Assertions.assertEquals(Cardinals.N.toString(), mower.getOrientation());
    }

    @Test
    public void givenInstructionAMowerSentBackItsCoordinate() {
        Mower mower = Remote.createMower("3 3 E");
        mower.setGarden(new Garden(5,5));
        mower.execute("AADAADADDA");
        String result = Remote.sendPosition(mower);
        Assertions.assertEquals("5 1 E ", result);
    }

    @Test
    public void givenAStringToCreateGarden(){
        Garden garden = Remote.createGarden(List.of("5 5","1 3 E"));
        Assertions.assertEquals(5, garden.getMaxY());
        Assertions.assertEquals(5, garden.getMaxX());
    }

}
