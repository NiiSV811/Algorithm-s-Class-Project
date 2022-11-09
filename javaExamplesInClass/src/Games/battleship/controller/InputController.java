package battleship.controller;

import battleship.model.BattleBoard;

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
