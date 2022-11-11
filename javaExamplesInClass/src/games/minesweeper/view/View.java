package minesweeper.view;

import minesweeper.controller.InputController;
import minesweeper.model.MineSweeperBoard;

import java.time.Duration;
import java.time.LocalTime;


/**
 * In this class the game is present, it includes title, styles to
 * make the game prettier, also a Battle Board is built and set its properties.
 *
 * @author Nicolas Sarmiento Vargas
 *  *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
 */

public class View {

    public static void main(String[] args) {
        InputController controller = new InputController();
        MineSweeperBoard main;
        int diffLevel = 0;
        int menuSelection = 0;
        int rows = 0;
        int columns = 0;
        int numOfMines = 0;
        int freeBoxes = 0;
        long seconds = 0;
        boolean inGame = true;
        double minePercent = 0;
        double timeGame = 0;
        LocalTime initialTime;
        LocalTime finishTime;

        String title = "                                                                                                                                   \n" +
                "\033[1;91m,-----.                                         ,--.                              ,--.             ,---.                           \n" +
                "\033[1;92m|  |) /_ ,--.,--. ,---.  ,---. ,--,--.,--,--,--.`--',--,--,  ,--,--. ,---.      ,-|  | ,---.      /  O  \\ ,--,--, ,--. ,--.,--,--. \n" +
                "\033[1;93m|  .-.  \\|  ||  |(  .-' | .--'' ,-.  ||        |,--.|      \\' ,-.  |(  .-'     ' .-. || .-. :    |  .-.  ||      \\ \\  '  /' ,-.  | \n" +
                "\033[1;94m|  '--' /'  ''  '.-'  `)\\ `--.\\ '-'  ||  |  |  ||  ||  ||  |\\ '-'  |.-'  `)    \\ `-' |\\   --.    |  | |  ||  ||  |  \\   ' \\ '-'  | \n" +
                "\033[1;95m`------'  `----' `----'  `---' `--`--'`--`--`--'`--'`--''--' `--`--'`----'      `---'  `----'    `--' `--'`--''--'.-'  /   `--`--' \n" +
                "                                                                                                                  `---'";

        String menuOptions = "\033[0mOpciones de Menú : \n1 -> Jugar\n2 -> Instrucciones \n3 -> Acerca De\n4 -> Salir";

        String instructions = "\033[1;94mBuscaminas De Anya: \n" +
                "\033[1;31m Objetivo:\n" +
                "\033[0mEn el buscaminas de Anya deberás cavar todo el tablero sin explotar ninguna mina.\n\n" +
                "\033[1;31m ¿Cómo Jugar? \n" +
                "\033[0mPara jugar lo que debes hacer es escribir la coordenada que quieres excavar, para\n" +
                "ello debes escribir con mayúscula el literal (A, B, C, D...) y luego el número\n" +
                "Ejemplo: A10 , B9 , F5 , F04\n\n" +
                "\033[1;31m Tip Extra \n" +
                "\033[0mAl excavar una casilla que esté rodeada por minas, solo se revelará dicha casillas\n" +
                "pero si la casilla no tiene minas cerca, se revelará el área circundante.\n\n";

        String about = "\033[1;93mACERCA\n" +
                "\033[0mEl buscaminas de Anya ha sido creado en base al popular juego de buscaminas\n" +
                "en inglés conocido como MineSweeper desarrollado por  Curt Johnson y Robert \n" +
                "Donner en 1989.Más conocido por estar presente en Microsoft Windows desde las \n" +
                "versiones 3.1 hasta la actualidad, ha sido desarrollado para otras plataformas \n" +
                "y en diversos lenguajes. Los niveles del buscaminas de Anya están basados en el \n" +
                "buscaminas de Google, se ha intentado aproximar los tableros y la cantidad de minas.\n\n" +
                "\033[94mPeanuts \033[95m<3\033[0m";

        String levels = "\033[0m1 -> \033[92mFácil (Anya)\033[0m\n" +
                "2 -> \033[93mNormal (Yor)\033[0m\n" +
                "3 -> \033[91mDifícil (Loid)\033[0m\n"+
                "Ingresa la dificultad en la que quiere jugar => ";

        while (inGame){

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(title);
            System.out.println(menuOptions);

            menuSelection = controller.selectOptions(1, 4, "Selecciona opción => ");

           while (menuSelection != 1 && menuSelection != 4){
               switch (menuSelection){
                   case 2 ->{
                       System.out.print("\033[H\033[2J");
                       System.out.flush();
                       System.out.println(title);
                       System.out.println(instructions);
                       menuSelection = controller.selectOptions(1, 1, "1 -> para Volver :  ");
                   }
                   case 3 ->{
                       System.out.print("\033[H\033[2J");
                       System.out.flush();
                       System.out.println(title);
                       System.out.println(about);
                       menuSelection = controller.selectOptions(1, 1, "1 -> para Volver :  ");
                   }

               }
               System.out.print("\033[H\033[2J");
               System.out.flush();
               System.out.println(title);
               System.out.println(menuOptions);
               menuSelection = controller.selectOptions(1, 4, "Selecciona opción => ");

           }
            if(!inGame || menuSelection == 4){
                break;
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(title);
            diffLevel = controller.selectOptions(1, 3, levels);

            switch (diffLevel) {

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
            freeBoxes = (rows * columns) - numOfMines;

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
            main.setGameStatus("\n");


            initialTime = LocalTime.now();
            while (main.getIsAlive() && main.getFreeBoxesCounter() != main.getFreeBoxes()){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                main.printMask();

                System.out.println(main.getGameStatus());
                System.out.println("Minas totales -> " + main.getNumMines());
                System.out.print("Casillas Excavadas -> " + main.getFreeBoxesCounter() + " de " + main.getFreeBoxes());

                controller.digTarget(main);

                main.setFreeBoxesCounter(0);
                main.updateCounter();
            }

            finishTime = LocalTime.now();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println();
            main.printBoard();

            if(main.getIsAlive()){
                System.out.println("\nHas ganado, Anya te ha regalado un maní");
            }else {
                main.setGameStatus("\n\033[91mHas explotado una mina X(\033[0m");
                System.out.println(main.getGameStatus());
                System.out.println("Has perdido, Anya está triste :_(");
            }

            seconds = Duration.between(initialTime, finishTime).getSeconds();
            timeGame = seconds / 60.0;
            if( seconds >= 60){
                System.out.println("Juego terminado en : " + String.format("%.2f", timeGame) + " minutos\n");
            }else {
                System.out.println("Juego terminado en : " + seconds + " segundos\n");
            }

            inGame = controller.playAgain();
        }


        System.out.println("Gracias por jugar: \033[91mBu\033[93msc\033[94mam\033[95min\033[91mas \033[92mde \033[93mAn\033[94mya \033[95m<3");



    }
}
