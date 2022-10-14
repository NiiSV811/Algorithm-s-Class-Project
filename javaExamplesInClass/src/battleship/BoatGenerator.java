package battleship;

import java.util.Random;

public class BoatGenerator {
    public static void main(char[][] board, int boatSize) {
        Random randomGenerator = new Random();
        int xCore=0;
        int yCore=0;
        int middleXCore=0;
        int middleYCore=0;
        int positionBoat=0;
        char boat='■';

        boolean isGenerated = false;

        while (!isGenerated){
            xCore = randomGenerator.nextInt(board.length-boatSize);

            yCore = randomGenerator.nextInt(board.length-boatSize);
            if( xCore+boatSize< board.length && yCore+boatSize< board.length-1){

                isGenerated = SearchingBoatArea(board,boatSize,xCore, yCore);
            }
        }

        switch (boatSize){

            case 3:{

                middleXCore = xCore + 1;
                middleYCore = yCore + 1;
                break;
            }
            case 5:{

                middleXCore = xCore + 2;
                middleYCore = yCore + 2;
                break;
            }
        }

        if(boatSize != 1){
            positionBoat = randomGenerator.nextInt(4);

            if( positionBoat == 0){ //vertically
                for(int y = yCore; y < yCore+boatSize; y++){
                    board[middleXCore][y]= boat;
                }

            } else if (positionBoat == 1) {//horizontally
                for(int x = xCore; x < xCore+boatSize; x++){
                    board[x][middleYCore]= boat;
                }

            } else if (positionBoat == 2) {//diagonally 1
                for(int i = 0; i<boatSize; i++){
                    board[xCore+i][yCore+i]= boat;
                }
            } else{//diagonally 2
                for(int i = boatSize-1, j = 0; i>=0; i--, j++){
                    board[xCore+i][yCore+j]= boat;
                }
            }
        }else {
            board[xCore][yCore]= boat;
        }


    }

    public static boolean SearchingBoatArea(char[][] board, int boatSize, int xCore, int yCore){
       for(int x = xCore; x < boatSize+xCore; x++){
           for(int y = yCore; y< boatSize+yCore; y++){
               if( board[x][y] =='■' ){
                   return false;
               }
           }
       }

        return true;
    }
}
