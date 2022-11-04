package co.edu.uptc.test.minesweeper.controller;

import javax.swing.*;

public class ParseController {

    public static boolean validateMove(char[][] board, String rowCore, String colCore){
        boolean squareExists= true;
        int row = 0;
        int col = 0;

        try {
            row = Integer.parseInt(rowCore);
            col = Integer.parseInt(colCore);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Casilla inválida");
        }


        if( row > 0 && row < board.length && col > 0 && col < board[row].length){
            return squareExists;
        }
        squareExists = false;
        return squareExists;
    }
}
