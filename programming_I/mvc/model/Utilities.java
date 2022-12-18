package mvc.model;

public class Utilities {
    //Attributes
    private int arrayResult[];
    private int arraySize;
    private boolean isCapicua;
    //Builder
    public Utilities(){
        this.arraySize = 0;
        isCapicua = false;
    }
    //setters

    public void setArraySize(int size){
        this.arraySize = size;
    }
    public void setArrayResult(){
        this.arrayResult = new int[this.arraySize];
    }
    public void setIsCapicua(boolean capicua){
        this.isCapicua = capicua;
    }

    //getters
    public int getArraySize(){
        return this.arraySize;
    }
    public int[] getArrayResult(){
        return this.arrayResult;
    }
    public boolean getIsCapicua(){
        return this.isCapicua;
    }

    //Methods

    //  Fibonacci
    public void FibonacciSequence(){
        int limit = this.arraySize;

        this.arrayResult[0] = 0;
        this.arrayResult[1] = 1;

        if(limit == 1){
            return;
        }

        for (int index = 2; index < limit; index++){
            this.arrayResult[index] = this.arrayResult[index-1] + this.arrayResult[index-2];
        }
    }
    //  Digits
    public void Digits(){

        for(int i = 0; i < this.arraySize; i++){
            this.arrayResult[i] = i;
        }
    }

    // Nums to Ten
    public void NumsTen(){
        for(int i = 1; i <= this.arraySize; i++){
            this.arrayResult[i-1] = i;
        }
    }

    //  Evens to Ten
    public void EvensToTen(){
        int even = 2;
        for(int i = 0; i < this.arraySize; i++){
            this.arrayResult[i] = even;
            even += 2;
        }
    }

    // Odds to Ten
    public void OddsToTen(){
        int odd = 1;
        for(int i = 0; i < this.arraySize; i++){
            this.arrayResult[i] = odd;
            odd += 2;
        }
    }
    //  Is Capicua?
    public void IsCapicua(String word){
        String reverseWord = "";
        word = word.toLowerCase();

        for(int c = word.length() - 1; c >=0 ; c--){
            reverseWord += word.charAt(c);
        }

        isCapicua = word.equals(reverseWord);
    }
}
