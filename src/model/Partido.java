package model;

public class Partido {

    private Jugador jugador1;
    private Jugador jugador2;
    private String torneo;
    private int sets;
    private int games;

    public Partido(Jugador jugador1, Jugador jugador2, String torneo){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.torneo = torneo;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
