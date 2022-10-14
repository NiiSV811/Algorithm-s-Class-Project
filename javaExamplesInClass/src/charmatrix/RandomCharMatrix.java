package com.charMatrix;

import java.util.Random;

public class RandomCharMatrix {
    public static void main(String[] args) {
        char [][] aRandomCharMatrix = CreateCharMatrix(10, 10);
	System.out.print("\033[H\033[2J");  
	System.out.flush(); 
        PrintingCharMatrix(aRandomCharMatrix);
    }

    public static char[][] CreateCharMatrix(int rows, int columns){
        Random randomChar = new Random();
        char[][] randomCharMatrix = new char[rows][columns];

        for(char[] row : randomCharMatrix){
            for(int column = 0 ; column< row.length; column++){
                row[column]= (char)(randomChar.nextInt(26)+'a');

            }
        }

        return randomCharMatrix;
    }

    public static void PrintingCharMatrix(char[][] charMatrix){

        for(int row = 0 ; row < charMatrix.length; row++){
            for (int column = 0 ; column < charMatrix[row].length; column++){
                if(charMatrix.length != 1){
                    //Text Decoration
                    if (row == 0 && column == 0) {
                        System.out.print("╔   ");

                    } else if (row == charMatrix.length - 1 && column == 0) {
                        System.out.print("╚   ");

                    } else if (column == 0) {
                        System.out.print("║   ");
                    }

                    System.out.print(charMatrix[row][column]+ "\t"); //Printing the character

                    //Text Decoration
                    if (row == 0 && column == charMatrix[row].length - 1) {
                        System.out.print("╗");
                    } else if (row == charMatrix.length - 1 && column == charMatrix[row].length - 1) {
                        System.out.print("╝");
                    } else if (column == charMatrix[row].length - 1) {
                        System.out.print("║");
                    }
                }else {
                    if(column == 0){
                        System.out.print("〚  ");
                    }

                    System.out.print(charMatrix[row][column] + "\t");

                    if(column== charMatrix[row].length-1){
                        System.out.print("〛");
                    }
                }
            }
            System.out.println(" ");
        
        }
    }
}
