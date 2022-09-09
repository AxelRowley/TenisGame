package ui;

import model.*;
import java.util.Scanner;

public class UIMenu {

    private static Partido partido;

    public static Partido getPartido() {
        return partido;
    }

    public static void setPartido(Partido partido) {
        UIMenu.partido = partido;
    }
    public static void showMenu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido\n\nA continuacion debera ingresar ciertos datos para comenzar una partida.");

        //comenzamos creando los jugadores
        System.out.println("\n\nIngrese el nombre del primer jugador");
        String jug1 = sc.nextLine();
        Jugador jugador1 = new Jugador(jug1);
        System.out.println("\n\nIngrese el nombre del segundo jugador");
        String jug2 = sc.nextLine();
        Jugador jugador2 = new Jugador(jug2);


        System.out.println("\n\nIngrese el nombre del Torneo");
        String torneo = sc.nextLine();
        //creamos un partido para comenzar la partida
        partido = new Partido(jugador1, jugador2, torneo);

        //y vamos a elegir el tipo de partido que queremos jugar
        menu();
    };
    private static void menu(){
        System.out.println("\n\nSelecciona la opcion deseada\n");

        int respuesta = 0;
        do{
            System.out.println("1. Partido de 3 sets");
            System.out.println("2. Partido de 5 sets");
            System.out.println("0. Salir");


            Scanner sc = new Scanner(System.in);
            respuesta = sc.nextInt();

            switch (respuesta) {
                case 1:
                    //vamos a jugar un partido de 3 sets
                    partido(3);
                    System.out.println("\nDesea continuar jugando?\n");
                    break;
                case 2:
                    //vamos a jugar un partido de 5 sets
                    partido(5);
                    System.out.println("\nDesea continuar jugando?\n");
                    break;
                case 0:
                    //salimos del juego
                    System.out.println("\nMuchas gracias.\n");
                    break;
                default:
                    System.out.println("\nPor favor, seleccione la respuesta correcta.\n");
            }
        }while (respuesta != 0);
    }
    private static void partido(int sets) {

        Scanner sc = new Scanner(System.in);

        int respuesta = 0;
        Double probabilidadJugador;

        do {
            System.out.println("\n\nIngrese la probabilidad de que "+ partido.getJugador1().getName() + " gane el juego: ejemplo [33,5]");
            probabilidadJugador = sc.nextDouble();
            System.out.println("\n");

            System.out.println("Probabilidad que " + partido.getJugador1().getName() + " gane: " + probabilidadJugador );
            System.out.println("Probabilidad que " + partido.getJugador2().getName() + " gane: " + (100 - probabilidadJugador) + "\n1. Correcto\n2. Cambiar Probabilidad");
            respuesta = sc.nextInt();

            if(respuesta == 1) {
                partido.getJugador1().setProbabilityWin(probabilidadJugador);
                partido.getJugador2().setProbabilityWin(100 - probabilidadJugador);
            }

        } while (respuesta == 2);

        //comenzamos el partido
        UIMenuSets.partidoSets(sets);
    }
}
