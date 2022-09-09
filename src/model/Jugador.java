package model;

public class Jugador {

    private String name;
    private double probabilityWin;

    public Jugador(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProbabilityWin() {
        return probabilityWin;
    }

    public void setProbabilityWin(double probabilityWin) {
        this.probabilityWin = probabilityWin;
    }
}
