package ui;

public class UIMenuSets {

    public static void partidoSets(int sets) {

        int gamesJugador1 = 0;
        int gamesJugador2 = 0;
        int setsJugador1 = 0;
        int setsJugador2 = 0;
        int setsTerminados = 0;
        int resultado[][] = new int[sets][2];
        int ganar;

        if(sets == 3) {
            ganar = 2;
        }else {
            ganar = 3;
        }

        do{
            while (gamesJugador1 < 6 && gamesJugador2 < 6){

                double probabilidadUno = ((int)(Math.random() * 100) * UIMenu.getPartido().getJugador1().getProbabilityWin());
                double probabilidadDos = ((int)(Math.random() * 100) * UIMenu.getPartido().getJugador1().getProbabilityWin());

                System.out.println("\nEl saque corresponde a " + UIMenu.getPartido().getJugador1().getName());

                //condicional if para saber a que jugador asignar el game
                if(probabilidadUno > probabilidadDos){

                    //incrementamos los games ganados
                    gamesJugador1++;

                    //mostramos el ganador del punto, a quien corresponde el saque y los ersultados parciales del set
                    System.out.println("\nEl ganador de este punto es el jugador " + UIMenu.getPartido().getJugador1().getName());

                    System.out.println("\nResultados parciales del set:\n" + UIMenu.getPartido().getJugador1().getName() + " = " + gamesJugador1 +
                                                                    "\n" + UIMenu.getPartido().getJugador2().getName() + " = " + gamesJugador2 );

                    System.out.println("\nEl saque corresponde a " + UIMenu.getPartido().getJugador2().getName());

                    //asignamos los resultados a un arreglo
                    resultado[setsTerminados][0] = gamesJugador1;
                    resultado[setsTerminados][1] = gamesJugador2;

                } else {
                    //incrementamos los games ganados
                    gamesJugador2++;

                    //mostramos el ganador del punto, a quien corresponde el saque y los ersultados parciales del set
                    System.out.println("\nEl ganador de este punto es el jugador " + UIMenu.getPartido().getJugador2().getName());

                    System.out.println("\nEl saque corresponde a " + UIMenu.getPartido().getJugador1().getName());

                    System.out.println("\nResultados parciales del set:\n" + UIMenu.getPartido().getJugador1().getName() + " = " + gamesJugador1 +
                                                                    "\n" + UIMenu.getPartido().getJugador2().getName() + " = " + gamesJugador2 );
                    //asignamos los resultados a un arreglo
                    resultado[setsTerminados][0] = gamesJugador1;
                    resultado[setsTerminados][1] = gamesJugador2;
                }
            }

            //incrementamos los sets ganados
            if (gamesJugador1 == 6){
                setsJugador1++;
            } else {
                setsJugador2++;
            }

            System.out.println("\nResultados parciales de Sets \n"
                    + UIMenu.getPartido().getJugador1().getName() + " = " + setsJugador1 + "\n"
                    + UIMenu.getPartido().getJugador2().getName() + " = " + setsJugador2 + "\n");

            gamesJugador1 = 0;//retornamos a 0 para comenzar un nuevo set
            gamesJugador2 = 0;//retornamos a 0 para comenzar un nuevo set
            setsTerminados++;//incrementamos los valores de los sets finalizados para luego asignar resultados al arreglo

        } while(setsJugador1 < ganar && setsJugador2 < ganar);


        //resultado final del partido
        System.out.println("__________________________________");
        System.out.print(UIMenu.getPartido().getJugador1().getName() + "         ");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i][0] + "  ");
        }
        System.out.print("      |" + "\n" + UIMenu.getPartido().getJugador2().getName() + "        ");
        for (int j = 0; j < resultado.length; j++) {
            System.out.print(resultado[j][1] + "  ");
        }
        System.out.print("      |" + "\n----------------------------------");


        //felicitamos al ganador del partido
        if (setsJugador1 == ganar){
            System.out.println("\n\n" + UIMenu.getPartido().getJugador1().getName() + " ha ganado el partido del Torneo " + UIMenu.getPartido().getTorneo());
        } else {
            System.out.println("\n\n" + UIMenu.getPartido().getJugador2().getName() + " ha ganado el partido del Torneo " + UIMenu.getPartido().getTorneo());
        }
    }
}
