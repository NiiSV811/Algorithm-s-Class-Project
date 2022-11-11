package battleship.model;


/**
 * Battle Boar Class, this class:
 *  - Generates the board and a mask to modify and play.
 *  - Controls the Game State, empty positions, hit positions
 *    and remaining moves.
 *
 * @author Nicolas Sarmiento Vargas
 * Git Hub: https://github.com/NiiSV811
 * @version 1.0
 */


public class BattleBoard {
    //Attributes
    private char board[][];
    private char mask[][];
    private int rows;
    private int columns;
    private int extraLargeBoatNumber;
    private int largeBoatNumber;
    private int bigBoatNumber;
    private int mediumBoatNumber;
    private int smallBoatNumber;
    private int totalHits;
    private int hitCounter;
    private int moves;
    private String status;


    //Constructor
    public BattleBoard(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        board = new char[this.rows][this.columns];
        mask = new char[this.rows][this.columns];

        this.extraLargeBoatNumber = 0;
        this.largeBoatNumber = 0;
        this.bigBoatNumber = 0;
        this.mediumBoatNumber = 0;
        this.smallBoatNumber = 0;
        this.totalHits = 0;
        this.hitCounter = 0;
        this.moves = 0;
        this.status = "";
    }

    //Set & Get

        //Board
    public void setBoard(){
        for(int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board[y].length; x++){
                this.board[y][x] = 'o';
            }
        }
    }

    public char[][] getBoard(){return this.board;}


        //Mask
    public void setMask(){
        for(int y = 0; y < this.mask.length; y++){
            for (int x = 0; x < this.mask[y].length; x++){
                this.mask[y][x] = '*';
            }
        }

    }

    public char[][] getMask(){return this.mask;}
    public char getMaskPos(int y, int x){return this.mask[y][x];}
    public void updateMaskPos(int y, int x){this.mask[y][x] = this.board[y][x];}

    //Extra Large Boats

    public void setExtraLargeBoatNumber(int xlargeBoats){this.extraLargeBoatNumber = xlargeBoats;}
    public int getExtraLargeBoatNumber(){return this.extraLargeBoatNumber;}

    //Large Boats
    public void setLargeBoatNumber(int largeBoats){this.largeBoatNumber = largeBoats;}

    //Big Boats
    public void setBigBoatNumber(int bigBoats){this.bigBoatNumber = bigBoats;}


    //Medium Boats
    public void setMediumBoatNumber(int mediumBoats){this.mediumBoatNumber = mediumBoats;}


    //Small Boats
    public void setSmallBoatNumber(int smallBoats){this.smallBoatNumber = smallBoats;}


    // Rows
    public int getRows(){return this.rows;}

    //Columns
    public int getColumns(){return this.columns;}

    //Hits
    public void setHits(){
        this.totalHits = (7 * this.extraLargeBoatNumber) + (5 * this.largeBoatNumber) + (3 * this.bigBoatNumber) + (2 * this.mediumBoatNumber) + this.smallBoatNumber;
    }
    public int getHits(){return this.totalHits;}

    //Hit Counter
    public void setHitCounter(int hitCounter){this.hitCounter = hitCounter;}
    public int getHitCounter(){return this.hitCounter;}


    //strikes
    public void setMoves(int updateMoves){this.moves = updateMoves;}
    public int getMoves(){return this.moves;}

    //Status
    public void setStatus(String status){ this.status = status;}
    public String getStatus(){return this.status;}


    // Position
    public char getPos(int y , int x){return this.board[y][x];}
    public void setPos(int y, int x, char symbol){this.board[y][x] = symbol;}





    //Mainly Methods

    /**
     * PrintBoard print the matrix with boats and empty positions with style
     * this uses for testing and to show at the end of the game.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     */

    public void printBoard(){
        char[] letters = new char[board[0].length];
        int[] numbers = new int[board.length];

        for(int i = 0; i< board.length; i++){
            numbers[i]= i+1;
        }
        for(int c = 0; c < board[0].length; c++){
            letters[c]= (char)('@'+ c+1);
        }

        System.out.print("\t\t"+"╔\t");
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

        System.out.print("\t\t"+"╚\t");
        for(char c : letters){
            System.out.print(" "+" ");
        }
        System.out.print("  ╝");

    }

    /**
     * PrintMask print the matrix that update in every turn,
     * use the method to show the user the board to interact.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     */

    public void printBoardMask(){
        char[] letters = new char[board[0].length];
        int[] numbers = new int[board.length];

        for(int i = 0; i< board.length; i++){
            numbers[i]= i+1;
        }
        for(int c = 0; c < board[0].length; c++){
            letters[c]= (char)('@'+ c+1);
        }

        System.out.print("\t\t"+"╔\t");
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

        System.out.print("\t\t"+"╚\t");
        for(char c : letters){
            System.out.print(" "+" ");
        }
        System.out.print("  ╝");

    }

    /**
     * setBoats: Set every type of boats on the board
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @see BoatUtil#BoatGenerator(BattleBoard, int);
     */
    public void setBoats(){
        BoatUtil generator = new BoatUtil();
        for (int xL = 0; xL < this.extraLargeBoatNumber; xL++){
            generator.BoatGenerator(this, 7);
        }
        for(int l = 0; l < this.largeBoatNumber; l++){
            generator.BoatGenerator(this, 5);
        }
        for(int b = 0; b < this.bigBoatNumber; b++){
            generator.BoatGenerator(this, 3);
        }
        for(int m = 0; m < this.mediumBoatNumber; m++){
            generator.BoatGenerator(this, 2);
        }
        for(int s = 0; s < this.smallBoatNumber; s++){
            generator.BoatGenerator(this, 1);
        }
    }









}
