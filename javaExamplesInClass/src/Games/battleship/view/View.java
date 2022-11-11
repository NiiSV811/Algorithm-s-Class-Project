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
                        "los barcos, perderás."
        );

        System.out.print("\nNiveles de Dificultad: \nFácil : 1\nNormal : 2\nDificil : 3\nNightMare : 4\n");

        while (inGame){
            levelDiff = controller.selectDifficulty(0,4);

            switch (levelDiff){
                case 0://Exit
                    inGame = false;
                    break;
                case 1: //Easy
                    totalBigBoats = 2;
                    totalMediumBoats = 3;
                    totalSmallBoats = 5;
                    extraMoves = 200;
                    rows = 15;
                    columns = 15;
                    break;

                case 2: //Normal
                    totalBigBoats = 3;
                    totalMediumBoats = 5;
                    totalSmallBoats = 7;
                    extraMoves = 250;
                    rows = 18;
                    columns = 18;
                    break;

                case 3://Hard /What do you do for playing this??
                    totalLargeBoats = 3;
                    totalBigBoats = 7;
                    totalMediumBoats = 4;
                    totalSmallBoats = 10;
                    extraMoves = 300;
                    rows = 22;
                    columns = 22;
                    break;

                case 4://NightMare You won't Win this game
                    totalXLargeBoats = 3;
                    totalLargeBoats = 5;
                    totalBigBoats = 9;
                    totalMediumBoats = 6;
                    totalSmallBoats = 11;
                    extraMoves = 400;
                    rows = 26;
                    columns = 26;
                    break;
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
                System.out.print("\nFelicitaciones Has Ganado\nʘ‿ʘ\n");
            }else{
                System.out.print("\nGame Over: Has perdido \nಥ﹏ಥ\n");
                mainBoard.printBoardMask();
                mainBoard.printBoard();

            }

            inGame = controller.playAgain();

        }

        System.out.println("Gracias por jugar");






    }
}
