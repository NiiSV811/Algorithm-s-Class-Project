package minesweeper.model;
import java.util.Random;

public class MineSweeperBoard {
    private char[][] board;
    private char[][] mask;
    private int rows;
    private int columns;
    private int numMines;
    private int freeBoxes;
    private int freeBoxesCounter;
    private boolean isAlive;

    private String gameStatus;

    public MineSweeperBoard(int rows, int columns){
        this.rows = rows;
        this.columns = columns;

        this.board = new char[this.rows][this.columns];
        this.mask = new char[this.rows][this.columns];
    }

    //Set & Get

    public void setNumMines(int numMines) {this.numMines = numMines;}
    public int getNumMines(){return this.numMines;}

    public void setFreeBoxes(int freeBoxes){this.freeBoxes = freeBoxes; }
    public int getFreeBoxes(){return this.freeBoxes;}

    public void setFreeBoxesCounter(int counterFreeBoxes){this.freeBoxesCounter = counterFreeBoxes;}
    public int getFreeBoxesCounter(){return this.freeBoxesCounter;}

    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}
    public boolean getIsAlive(){return this.isAlive;}

    public void setGameStatus(String newStatus){this.gameStatus = newStatus;}
    public String getGameStatus(){return this.gameStatus;}

    public void setBoard(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                this.board[y][x] = '0';
            }
        }
    }

    public char[][] getBoard() {return this.board;}

    public void setMask(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                this.mask[y][x] = '■';
            }
        }
    }
    public char[][] getMask() {return this.mask;}

    public char getPos(int y, int x){return this.board[y][x];}
    public void setMaskPos(int y, int x){
        this.mask[y][x] = this.board[y][x];
    }
    public char getMaskPos(int y, int x){return this.mask[y][x];}

    //Methods

    //Print Board
    public void printBoard(){
        char[] letters = new char[board[0].length];
        int[] numbers = new int[board.length];

        for(int i = 0; i< board.length; i++){
            numbers[i]= i+1;
        }
        for(int c = 0; c < board[0].length; c++){
            letters[c]= (char)('@'+ c+1);
        }

        System.out.print("\t\t"+"╔\t\t");
        for(char c : letters){
            System.out.print(c+" ");
        }
        System.out.print("  ╗\n");
        for(int row = 0 ; row < board.length; row++){
            for (int column = 0 ; column < board[row].length; column++){

                //Text Decoration
                if ( column == 0) {
                    System.out.print("\t\t"+"║  " +String.format("%02d",numbers[row])+"\t");
                }

                System.out.print(board[row][column]+ " "); //Printing the character

                //Text Decoration
                if (column == board[row].length - 1) {
                    System.out.print("  ║");

                }
            }
            System.out.println(" ");
        }

        System.out.print("\t\t"+"╚\t\t");
        for(char c : letters){
            System.out.print(" "+" ");
        }
        System.out.print("  ╝");
    }

    //Print Mask
    public void printMask(){
        char[] letters = new char[board[0].length];
        int[] numbers = new int[board.length];

        for(int i = 0; i< board.length; i++){
            numbers[i]= i+1;
        }
        for(int c = 0; c < board[0].length; c++){
            letters[c]= (char)('@'+ c+1);
        }

        System.out.print("\t\t"+"╔\t\t");
        for(char c : letters){
            System.out.print(c+" ");
        }
        System.out.print("  ╗\n");
        for(int row = 0 ; row < board.length; row++){
            for (int column = 0 ; column < board[row].length; column++){

                //Text Decoration
                if ( column == 0) {
                    System.out.print("\t\t"+"║  " +String.format("%02d",numbers[row])+"\t");
                }

                System.out.print(mask[row][column]+ " "); //Printing the character

                //Text Decoration
                if (column == board[row].length - 1) {
                    System.out.print("  ║");

                }
            }
            System.out.println(" ");
        }

        System.out.print("\t\t"+"╚\t\t");
        for(char c : letters){
            System.out.print(" "+" ");
        }
        System.out.print("  ╝");
    }

    //Set Mines
    public void setMines(){
        Random randGen = new Random();
        int posX = 0;
        int posY = 0;
        int iterator = 0;
        while (iterator < this.numMines){
            posX = randGen.nextInt(this.columns-1);
            posY = randGen.nextInt(this.rows-1);

            if(this.board[posY][posX] == '0'){
                this.board[posY][posX] = 'x';
                iterator++;
            }

        }

    }

    public void setNumbers(){
        int mineCounter = 0;
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                if(this.board[y][x] != 'x'){
                    mineCounter = minesAround(y, x);
                    this.board[y][x] = (char)(mineCounter + '0');
                }
            }
        }
    }

    private int minesAround(int posY, int posX){
        int mineCount = 0;
        for(int iy= -1 ;iy <=1; iy++){
            for (int ix= -1; ix <= 1; ix++){
                try {
                    if(this.board[posY+iy][posX+ix] =='x'){
                        mineCount = mineCount + 1;
                    }
                }catch (Exception e){}
            }
        }
        return mineCount;
    }

    public void unlockAround(int posY, int posX){
        String xStorage = "";
        String yStorage = "";
        for(int iy= -1 ;iy <=1; iy++){
            for (int ix= -1; ix <= 1; ix++){
                try {
                    if(this.getPos(posY + iy, posX + ix) == '0'){
                        if(this.getMaskPos(posY + iy, posX + ix) == '■'){
                            this.setMaskPos(posY + iy, posX + ix);
                            unlockAround( posY + iy, posX + ix);
                        }
                    }else {
                        this.setMaskPos(posY + iy, posX + ix);
                    }

                }catch (Exception e){}
            }
        }

    }

    public void updateCounter(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[0].length; x++){
                if(this.getMaskPos(y, x) != '■'){
                    this.freeBoxesCounter++;
                }
            }
        }
    }


}
