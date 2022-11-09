package minesweeper.view;

import minesweeper.controller.InputController;
import minesweeper.model.MineSweeperBoard;

import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        InputController controller = new InputController();
        MineSweeperBoard main;
        int diffLevel = 0;
        int rows = 0;
        int columns = 0;
        int numOfMines = 0;
        double minePercent = 0;
        int freeBoxes = 0;
        boolean inGame = true;

        diffLevel = controller.selectDifficulty(0, 3);

        switch (diffLevel) {
            case 0 -> {
                inGame = false;
            }
            case 1 -> {
                rows = 14;
                columns = 6;
                minePercent = 0.12;

            }
            case 2 -> {
                rows = 20;
                columns = 9;
                minePercent = 0.20;

            }
            case 3 -> {
                rows = 28;
                columns = 13;
                minePercent = 0.21;
            }
        }

        numOfMines = (int)((rows * columns)*minePercent);
        freeBoxes = rows *  columns;

        main = new MineSweeperBoard(rows, columns);
        main.setBoard();
        main.setMask();
        main.setNumMines(numOfMines);
        main.setFreeBoxes(freeBoxes);
        main.setIsAlive(true);
        main.setGameStatus("\n");
        main.setFreeBoxesCounter(0);

        main.setMines();
        main.setNumbers();

        while (main.getIsAlive() == true && main.getFreeBoxesCounter() != main.getFreeBoxes()){
            main.printMask();
            System.out.print(main.getGameStatus());
            System.out.println("Minas totales -> " + main.getNumMines());
            System.out.print("Casillas Excavadas -> " + main.getFreeBoxesCounter());
            controller.digTarget(main);
            main.setGameStatus("\n");
            main.setFreeBoxesCounter(0);
            main.updateCounter();
        }








    }
}
