package co.edu.uptc.test.minesweeper.view;

import co.edu.uptc.test.minesweeper.model.MineSweeperBoard;


import javax.swing.*;
import java.util.Arrays;

public class View {
    public static void main(String[] args) {
        int moves = 0;
        int numOfMines = 0;
        double calcMines = 0;
        int numRows = 0;
        int numCols = 0;
        int rowIndex = 0;
        int colIndex = 0;
        String[] levels = new String[]{"easy", "normal", "hard"};
        String[] positionsRow;
        String[] positionsCol;
        String diff = "";
        String rowPos = "";
        String colPos = "";
        boolean touchedMine = false;

        diff = (String) JOptionPane.showInputDialog(null," Buscaminas de Anya \nPara empezar selecciona tu dificultad ",
                "Buscaminas de Anya",JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);

        switch (diff){
            case "easy":
                numRows = 5;
                break;
            case "normal":
                numRows = 8;
                break;
            case "hard":
                numRows = 12;
        }

        numCols = numRows + 4;
        calcMines = (numRows * numCols) * 0.8;
        numOfMines = (int)calcMines;
        moves = (numRows*numCols) - numOfMines;

        MineSweeperBoard easyBoard = new MineSweeperBoard(numRows, numCols, numOfMines);
        easyBoard.setBoard();
        easyBoard.setMines();
        easyBoard.setBoardMask();

        positionsRow = new String[numRows];
        positionsCol = new String[numCols];

        for(int r = 0; r < numRows; r++){
            positionsRow[r] = String.valueOf(r+1);
        }
        for(int c = 0; c < numCols; c++){
            positionsCol[c] = String.valueOf(c+1);
        }



        while (moves > 0 && !touchedMine){
            rowPos = (String) JOptionPane.showInputDialog(null," Posicion horizontal ",
                    "Buscaminas de Anya",JOptionPane.QUESTION_MESSAGE, null, positionsRow, positionsRow[0]);

            colPos = (String) JOptionPane.showInputDialog(null," Posicion horizontal ",
                    "Buscaminas de Anya",JOptionPane.QUESTION_MESSAGE, null, positionsCol, positionsCol[0]);

            rowIndex = Integer.parseInt(rowPos);
            colIndex = Integer.parseInt(colPos);

            if (easyBoard.getBoardPosition(rowIndex, colIndex) != 'x'){
                easyBoard.setBoardMaskSquare(rowIndex, colIndex);
                moves = moves - 1;
                System.out.println("hola");
                JOptionPane.showInputDialog(null, easyBoard.printBoard() + "\n Movimientos restantes " + moves);
            }else {
                touchedMine = true;
                JOptionPane.showMessageDialog(null, easyBoard.printBoard() + "\n Movimientos restantes " + moves +
                        "\n Has perdido :(");
            }

        }







    }
}
