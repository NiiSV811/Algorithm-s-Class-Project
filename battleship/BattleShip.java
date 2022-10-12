package com.battleship;

import java.util.Arrays;
import java.util.Scanner;


public class BattleShip {
    public static void main(String[] args) throws InterruptedException {
        //variables
        int boardSize = 0;
        int numBigBoats = 0;
        int numMediumBoats = 0;
        int numSmallBoats = 0;
        int diffLevel =0;
        boolean isSelectedLevel= false;
        int strikes = 0;
        int totalHits = 0;
        int hitCounter = 0;
        int xCore = 0;
        int yCore = 0;
        String levelInput = "";
        String coreInputs = "";
        String status = "\n";


        Scanner inputLine = new Scanner(System.in);

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



        
        System.out.print("El juego tiene 3 dificultades: \n1. Fácil \n2. Medio \n3. Difícil\n");

        while (!isSelectedLevel){
            System.out.print("Selecciona tu dificultad => ");
            levelInput= inputLine.next();
            try {
                diffLevel = Integer.parseInt(levelInput);
                if(diffLevel == 1 || diffLevel == 2 || diffLevel ==3){
                    isSelectedLevel = true;
                }else {
                    System.out.println("Comando invalido");
                }
            }catch (Exception e){

                System.out.println("Comando invalido");
            }
        }

        switch (diffLevel){
            case 1:{
                boardSize=10;
                numBigBoats = 1;
                numMediumBoats = 3;
                numSmallBoats = 5;
                strikes = 40;
                break;
            }
            case 2:{
                boardSize = 15;
                numBigBoats = 2;
                numMediumBoats = 4;
                numSmallBoats  = 6;
                strikes = 50;
                break;
            }
            case 3:{
                boardSize = 26;
                numBigBoats = 3;
                numMediumBoats = 5;
                numSmallBoats = 9;
                strikes = 100;
                break;
            }
        }

	System.out.print("\033[H\033[2J");
        System.out.flush();

        totalHits = (numBigBoats*5) + (numMediumBoats*3) + numSmallBoats;
        strikes += totalHits;

	System.out.println(" ");
        char[][] theBoard = GenerateBoard(boardSize,numBigBoats,numMediumBoats,numSmallBoats);
        char[][] theBoardMask = GenerateMask(boardSize);

        while (strikes > 0 && totalHits != hitCounter){
            PrintingBoard(theBoardMask);
            System.out.print(status);
            System.out.print("\nTiros restantes => "+strikes);
	    System.out.print("\nPosiciones faltantes => " + (totalHits - hitCounter));
            status = "\n";
            System.out.print("\nIngresa la coordenada a atacar => ");
            coreInputs = inputLine.next();


            try {
                yCore = coreInputs.charAt(0) - 65;
                coreInputs = coreInputs.replace(String.valueOf(coreInputs.charAt(0)),"");
                xCore = Integer.parseInt(coreInputs)-1;
                if( theBoardMask[xCore][yCore]== '□'){
                    strikes--;
                    theBoardMask[xCore][yCore] = theBoard[xCore][yCore];
                    if (theBoard[xCore][yCore] == '■'){
                        hitCounter++;
                        status = "\nHas impactado";
                    }
                }else {
                    status = "\nYa has atacado esa casilla";
                }

            }catch (Exception e){
                status = "\nCoordenada invalida. Vuelve a intentarlo";
            }


            //Limpiar Consola
            System.out.print("\033[H\033[2J");
            System.out.flush();
            //

        }

        PrintingBoard(theBoardMask);
        if(hitCounter == totalHits){
            System.out.println("\nGAME OVER: Has Ganado :D");
        }else{
            System.out.println("\nGAME OVER: Has perdido");
            PrintingBoard(theBoard);
        }




    }


    public static char[][] GenerateBoard(int boardSize, int bigBoats, int mediumBoats, int smallBoats){

        char [][] board = new char[boardSize][boardSize];

        for (int i=0; i < bigBoats; i++){
            BoatGenerator.main(board,5);
        }

        for (int i=0; i < mediumBoats; i++){
            BoatGenerator.main(board,3);
        }

        for (int i=0; i < smallBoats; i++){
            BoatGenerator.main(board,1);
        }


        for(int row = 0; row < board.length; row++){
            for (int column = 0; column < board[row].length; column++){
                if(board[row][column] != '■'){
                    board[row][column]= '*';
                }
            }
        }
        return board;
    }

    public static char[][] GenerateMask(int size){
        char[][] mask = new char[size][size];
        for (char[] chars : mask) {
            Arrays.fill(chars, '□');
        }
        return mask;
    }


    public static void PrintingBoard(char [][] mask){

        char[] letters = new char[mask.length];
        int[] numbers = new int[mask.length];

        for(int i = 0; i< mask.length; i++){
            numbers[i]= i+1;
            letters[i]= (char)('@'+ i+1);
        }
        System.out.print("\t\t"+"╔\t");
        for(char c : letters){
            System.out.print(c+" ");
        }
        System.out.print("  ╗\n");
        for(int row = 0 ; row < mask.length; row++){
            for (int column = 0 ; column < mask[row].length; column++){

                //Text Decoration
                if ( column == 0) {
                    System.out.print("\t\t"+"║  " +String.format("%02d",numbers[row])+"\t");
                }

                System.out.print(mask[row][column]+ " "); //Printing the character

                //Text Decoration
                if (column == mask[row].length - 1) {
                    System.out.print("  ║");

                }
            }
            System.out.println(" ");
        }
        System.out.print("\t\t╚\t");
        for(int i= 0; i< 2*mask.length;i++){
            System.out.print(" ");
        }
        System.out.print("  ╝");
    }


}

