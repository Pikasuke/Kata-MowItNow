package fr.codeworks.models;

public class Garden {

    private final int maxX;
    private final int maxY;

    public Garden(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean isInVerticalLimits(int y) {
         return (maxY >= y && y >= 0);
    }
    public boolean isInHorizontalLimits(int x) {
        return (maxX >= x && x >= 0);
    }
}

