package battleship.controller;

import battleship.model.BattleBoard;

import java.util.Scanner;

/**
 * InputController is for manage inputs and
 * manage exceptions if the user enter a invalid
 * command
 *
 *@author Nicolas Sarmiento Vargas
 *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
 *@version 1.0
 */

public class InputController {
    Scanner input = new Scanner(System.in);
    private int option = 0;

    /**
     * This method is uses to select the difficulty
     * levels
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @return int for levels
     */
    public int selectDifficulty(int minOption, int maxOption){

        while (true){
            try {
                System.out.print("Ingresa la dificultad en la que quiere jugar => ");
                this.option = input.nextInt();

                if(this.option >= minOption && this.option <= maxOption){
                    break;
                }else{
                    System.out.print("\nComando Inválido, intentelo de nuevo ");
                }
            }catch (Exception e){
                System.out.println("Ingrese un número");
            }

        }

        return this.option;
    }

    /**
     * This method parse inputs and modify Battle Board,
     * then update the game state
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     */

    public void selectTarget(BattleBoard board){
        int tarX = 0;
        int tarY = 0;
        System.out.print("\nIngresa la coordenada a atacar => ");

        String targetInputs = input.next();


        try {
            tarX = targetInputs.charAt(0) - 65;
            targetInputs = targetInputs.replace(String.valueOf(targetInputs.charAt(0)),"");
            tarY = Integer.parseInt(targetInputs)-1;

            if( board.getMaskPos(tarY, tarX) == '*'){
                board.setMoves(board.getMoves()-1);
                board.updateMaskPos(tarY, tarX);

                if (board.getPos(tarY, tarX) == '■'){
                    board.setHitCounter(board.getHitCounter()+1);
                    board.setStatus("\nHas impactado");
                }else {
                    board.setStatus("\n");
                }

            }else {
                board.setStatus("\nYa has atacado esa casilla");
            }

        }catch (Exception e){
            board.setStatus("\nCoordenada invalida. Vuelve a intentarlo");
        }

    }

    /**
     * This method calls when a user finish a game and ask for
     * replaying
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @return if the user wants to play again.
     */


    public boolean playAgain(){
        System.out.println("Volver a jugar : 1 \nSalir: Ingrese cualquier digito");
        System.out.print("Desea volver a jugar? => ");
        try{
            this.option = input.nextInt();

            if (this.option == 1){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
