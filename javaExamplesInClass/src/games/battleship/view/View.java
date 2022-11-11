package battleship.view;

import battleship.controller.InputController;
import battleship.model.BattleBoard;

/**
 * This class show titles, messages, set Battle Board values
 * Calls Input controller to play, and update the board in a loop
 * also verify when the user finish a game.
 *
 *@author Nicolas Sarmiento Vargas
 *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
 *@version 1.0
 */

public class View {
    public static void main(String[] args) {
        BattleBoard mainBoard;
        InputController controller = new InputController();
        int levelDiff = 0;

        int rows = 0;
        int columns = 0;
        int totalXLargeBoats = 0;
        int totalLargeBoats = 0;
        int totalBigBoats = 0;
        int totalMediumBoats = 0;
        int totalSmallBoats = 0;
        int extraMoves = 0;
        boolean inGame = true;
        int remainingPositions = 0;

        String title = "\n" +
                ".______        ___   .___________.___________. __       _______         _______. __    __   __  .______   \n" +
                "|   _  \\      /   \\  |           |           ||  |     |   ____|       /       ||  |  |  | |  | |   _  \\  \n" +
                "|  |_)  |    /  ^  \\ `---|  |----`---|  |----`|  |     |  |__         |   (----`|  |__|  | |  | |  |_) | \n" +
                "|   _  <    /  /_\\  \\    |  |        |  |     |  |     |   __|         \\   \\    |   __   | |  | |   ___/  \n" +
                "|  |_)  |  /  _____  \\   |  |        |  |     |  `----.|  |____    .----)   |   |  |  |  | |  | |  |      \n" +
                "|______/  /__/     \\__\\  |__|        |__|     |_______||_______|   |_______/    |__|  |__| |__| | _|";

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(title);

        System.out.println(
                "Bienvenido a Battle Ship: Este es un juego de estrategia donde el objetivo es derribar los barcos enemigos.\n"+
                        "En el juego encontraras una matriz n x n y para atacar posiciones debes escribir la coordenada empezando con\n"+
                        "la letra y luego el numero. Ejemplos: A5, G8 , j10... Si al atacar te aparece un '■' has impactado un barco.\n"+
                        "En la parte inferior del tablero aparecerán tus tiros disponibles, si se te acaban antes de derribar todos\n"+
                        "los barcos, perderás.\n" +
                        "Los tipos de barcos son: Extra Largos(7), Largos(5), Grandes(3), Medianos(2), Pequeños(1)\n"+
                        "Los tamaños de los tableros y cantidad de barcos son:\n" +
                        "Muy fácil: filas:10 , columnas: 10 , barcos grandes: 1 , barcos medianos: 1 , barcos pequeños : 1\n" +
                        "Fácil : filas: 15, columnas: 15, barcos grandes: 2, barcos medianos: 3, barcos pequeños: 5\n" +
                        "Normal: filas: 18, columnas: 18, barcos grandes: 3, barcos medianos: 5, barcos pequeños: 7\n" +
                        "Difícil: filas: 22, columnas: 22, barcos largos: 3, barcos grandes: 7, barcos medianos: 4, barcos pequeños: 10\n" +
                        "NightMare: filas: 26, columnas: 26,barcos extra Largos: 3, barcos largos: 5, barcos grandes: 9, barcos medianos: 6, barcos pequeños: 11\n"
        );

        System.out.print("\nNiveles de Dificultad: \nMuy fácil : 1\nFácil : 2\nNormal : 3\nDifícil : 4\nNigthMare : 5\n");

        while (inGame){
            levelDiff = controller.selectDifficulty(0,5);

            switch (levelDiff) {
                case 0 ->inGame = false; //Exit
                case 1 -> {
                    totalBigBoats = 1;
                    totalMediumBoats = 1;
                    totalSmallBoats = 1;
                    extraMoves = 30;
                    rows = 10;
                    columns = 10;
                }
                case 2 -> { //Easy
                    totalBigBoats = 2;
                    totalMediumBoats = 3;
                    totalSmallBoats = 5;
                    extraMoves = 200;
                    rows = 15;
                    columns = 15;
                }
                case 3 -> { //Normal
                    totalBigBoats = 3;
                    totalMediumBoats = 5;
                    totalSmallBoats = 7;
                    extraMoves = 250;
                    rows = 18;
                    columns = 18;
                }
                case 4 -> {//Hard /What do you do for playing this??
                    totalLargeBoats = 3;
                    totalBigBoats = 7;
                    totalMediumBoats = 4;
                    totalSmallBoats = 10;
                    extraMoves = 300;
                    rows = 22;
                    columns = 22;
                }
                case 5 -> {//NightMare You won't Win this game
                    totalXLargeBoats = 3;
                    totalLargeBoats = 5;
                    totalBigBoats = 9;
                    totalMediumBoats = 6;
                    totalSmallBoats = 11;
                    extraMoves = 400;
                    rows = 26;
                    columns = 26;
                }
            }

            if(!inGame){
                break;
            }

            mainBoard = new BattleBoard(rows, columns);

            mainBoard.setExtraLargeBoatNumber(totalXLargeBoats);
            mainBoard.setLargeBoatNumber(totalLargeBoats);
            mainBoard.setBigBoatNumber(totalBigBoats);
            mainBoard.setMediumBoatNumber(totalMediumBoats);
            mainBoard.setSmallBoatNumber(totalSmallBoats);

            mainBoard.setHits();
            mainBoard.setMoves(mainBoard.getHits() + extraMoves);
            mainBoard.setStatus("\n");

            mainBoard.setBoard();
            mainBoard.setBoats();
            mainBoard.setMask();

            mainBoard.setStatus("\n");

            while (mainBoard.getMoves() > 0 && mainBoard.getHitCounter() != mainBoard.getHits()){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                mainBoard.printBoardMask();

                remainingPositions = mainBoard.getHits() - mainBoard.getHitCounter();
                System.out.print(mainBoard.getStatus());
                System.out.print("\nTiros restantes => " + mainBoard.getMoves());
                System.out.print("\nPosiciones a atacar restantes => " + remainingPositions);
                controller.selectTarget(mainBoard);

            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

            if(mainBoard.getMoves() >= 0 && mainBoard.getHitCounter() == mainBoard.getHits()){
                System.out.print("\nFelicitaciones Has \033[92mGanado\033[0m\nʘ‿ʘ\n");
            }else{
                System.out.print("\nGame Over: Has \033[91mperdido\033[0m \nಥ﹏ಥ\n");
                mainBoard.printBoardMask();
                mainBoard.printBoard();

            }

            inGame = controller.playAgain();

        }

        System.out.println("Gracias por jugar");






    }
}
