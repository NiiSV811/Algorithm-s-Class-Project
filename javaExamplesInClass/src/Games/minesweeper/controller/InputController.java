package minesweeper.controller;
import minesweeper.model.MineSweeperBoard;

import java.util.Scanner;
public class InputController {
    Scanner input = new Scanner(System.in);
    private int option = 0;
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
                        board.setGameStatus("Has explotado una mina X(");
                    }
                    case '0' -> board.unlockAround(digY, digX);
                    default -> board.setMaskPos(digY, digX);
                }

            }else {
                board.setGameStatus("Esta casilla ya ha sido cavada :D");
            }

        }catch (Exception e){
            board.setGameStatus("Coordena inválida, vuelvelo a intentar >:v");
        }

    }
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
