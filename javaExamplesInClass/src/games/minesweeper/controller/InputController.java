package minesweeper.controller;
import minesweeper.model.MineSweeperBoard;

import java.util.Scanner;

/** InputController is for manage inputs and
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
     *
     * Manage Parse Execptions from the input.
     *
     * @author Nicolas Sarmiento Vargas
     *  *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @param minOption the minimum option value
     * @param maxOption the maximum option value
     * @param message show a message
     * @return the selected option
     */
    public int selectOptions(int minOption, int maxOption, String message){

        while (true){
            try {
                System.out.print(message);
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
     * Uses coordinates to dig a slot in an Mine Sweeper
     * Object
     * @author Nicolas Sarmiento Vargas
     *  *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @param board MineSweeper Object
     */
    public void digTarget(MineSweeperBoard board){
        String digInputs;
        int digX = 0;
        int digY = 0;
        System.out.print("\nIngresa la coordenada a atacar => ");

        digInputs = input.next();

        try {
            digX = digInputs.charAt(0) - 65;
            digInputs = digInputs.replace(String.valueOf(digInputs.charAt(0)),"");
            digY = Integer.parseInt(digInputs)-1;

            if ( board.getMaskPos(digY, digX) == '■'){

                switch (board.getPos(digY, digX)) {
                    case 'x' -> {
                        board.setMaskPos(digY, digX);
                        board.setIsAlive(false);
                    }
                    case '0' -> board.unlockAround(digY, digX);
                    default -> board.setMaskPos(digY, digX);
                }
                board.setGameStatus("\n");
            }else {
                board.setGameStatus("\nEsta casilla ya ha sido cavada :D");
            }

        }catch (Exception e){
            board.setGameStatus("\nCoordena inválida, vuelvelo a intentar >:v");
        }

    }

    /**
     * Manage an input to present to ask the user to  play again
     * @author Nicolas Sarmiento Vargas
     *  *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @return if the user wants to play again
     */
    public boolean playAgain(){
        System.out.println("Anya necesita que le ayudes a ganar : 1 \nSalir: Ingrese cualquier digito");
        System.out.print("Desea volver al inicio? => ");
        try{
            this.option = input.nextInt();

            if (this.option == 1){
                return true;
            }
        }catch (Exception e){}
        return false;
    }

}
