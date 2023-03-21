package fr.codeworks;

import fr.codeworks.models.Garden;
import fr.codeworks.models.Mower;
import fr.codeworks.enums.Cardinals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GardenTest {

    @Test
    public void ifMowerCoordinateIsOutOfBondGiveFalse() {
        Mower mower = new Mower(1, 1, Cardinals.N, new Garden(5, 5));
        Assertions.assertEquals(mower.getGarden().isInVerticalLimits(mower.getX()), true);
        mower.setY(5);
        Assertions.assertEquals(mower.getGarden().isInVerticalLimits(mower.getY()), true);
        mower.setX(6);
        Assertions.assertEquals(mower.getGarden().isInHorizontalLimits(mower.getX()), false);
        mower.setX(-1);
        Assertions.assertEquals(mower.getGarden().isInHorizontalLimits(mower.getX()), false);
    }
}