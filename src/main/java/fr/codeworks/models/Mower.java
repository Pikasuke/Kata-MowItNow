package fr.codeworks.models;

import fr.codeworks.enums.Cardinals;

public class Mower {

    private int x;
    private int y;
    private Cardinals orientation;
    private Garden garden;

    public Mower(int x, int y, Cardinals orientation, Garden garden) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.garden = garden;
    }

    public Mower() {
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setOrientation(Cardinals orientation) {
        this.orientation = orientation;
    }
    public String getOrientation() {
        return orientation.toString();
    }

    public Garden getGarden() {
        return garden;
    }

    @Override
    public String toString() {
        return "Mower{" +
                "x=" + x +
                ", y=" + y +
                ", orientation='" + orientation + '\'' +
                ", garden=" + garden +
                '}';
    }

    public void foward() {
        if (orientation.equals(Cardinals.N) && garden.isInVerticalLimits(getY()+1)) {
            setY(getY()+1);
        }
        if (orientation.equals(Cardinals.S) && garden.isInVerticalLimits(getY()-1)) {
            setY(getY()-1);
        }
        if (orientation.equals(Cardinals.E) && garden.isInHorizontalLimits(getX()+1)) {
            setX(getX()+1);
        }
        if (orientation.equals(Cardinals.W) && garden.isInHorizontalLimits(getX()-1)) {
            setX(getX()-1);
        }
    }

    public void turn(String way) {
        String cardinals = "";
        for (Enum cardinal: Cardinals.values()) {
            cardinals = cardinals+cardinal;
        }
        int indexOfCardinals = cardinals.indexOf(orientation.toString());
        if (way.equals("D")) {
            if (!getOrientation().equals(Cardinals.W.toString())) {
                indexOfCardinals = indexOfCardinals + 1;
            } else {
                indexOfCardinals = 0;
            }
        }
        if (way.equals("G")) {
            if (!getOrientation().equals(Cardinals.N.toString())) {
                indexOfCardinals = indexOfCardinals - 1;
            } else {
                indexOfCardinals = 3;
            }
        }
        setOrientation(Cardinals.valueOf(String.valueOf(cardinals.charAt(indexOfCardinals))));
    }

    public void execute(String instructions) {
        String[] instructionsLetter = instructions.split("");
        for (String letter: instructionsLetter) {
            if(letter.equals("A")) {
                foward();
            }
            turn(letter);
        }
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }
}
