package co.edu.uptc.model;

public class MathUtil {

    private int [] arrayResult;

    public int[] getArrayResult() {
        return arrayResult;
    }

    public  void calcEvenNumbers(int limit){

        if(limit % 2 == 0){
            this.arrayResult = new int[limit/2];
        }else{
            this.arrayResult = new int[(limit-1)/2];
        }


        int iterator = 1;
        int index = 0;
        while (iterator <=limit ){

            if (iterator % 2 == 0){
                this.arrayResult[index] = iterator;
                index ++;
            }
            iterator++;
        }
    }

    public  void calcOddNumbers(int limit){
        if(limit % 2 == 0){
            this.arrayResult = new int[limit/2];
        }else{
            this.arrayResult = new int[(limit + 1)/2];
        }
        int iterator = 1;
        int index = 0;
        while (iterator <= limit){
            if (iterator % 2 != 0){
                arrayResult[index]= iterator;
                index++;
            }
            iterator++;
        }
    }

    public void calcCousinNumbers(int limit){
        String primeNumbers = "";
        int iterator = 2;
        boolean isPrime;
        while (iterator <=limit){
            isPrime = true;
            for (int count = 2; count < iterator; count++){
                if(iterator % count == 0 ){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primeNumbers = primeNumbers + iterator;
            }
            iterator++;
        }
        int numAddtoArray = 0;
        this.arrayResult = new int[primeNumbers.length()];
        for(int prime = 0; prime < arrayResult.length; prime++){
            numAddtoArray = Integer.parseInt(String.valueOf(primeNumbers.charAt(prime)));
            this.arrayResult[prime] = numAddtoArray;
        }


    }


    public static Boolean isCapicua(String numberToCheck){
        boolean isCapicua = false;
        String inverseNumber = "";
        int iterator = numberToCheck.length() - 1;
        while(0 <= iterator){
            inverseNumber = inverseNumber + numberToCheck.charAt(iterator);

            iterator--;
        }

        if (inverseNumber.equals(numberToCheck)){
            return true;
        }
        return false;

    }

    public void calcEvenNumbersFromTo(int floorLimit, int topLimit){
        int len = topLimit - floorLimit;

        if(len % 2 == 0){
            this.arrayResult = new int[len/2];
        }else{
            this.arrayResult = new int[(len-1)/2];
        }
        int index = 0;
        int iterator = floorLimit;
        while (iterator <= topLimit ){

            if (iterator%2 == 0){
               this.arrayResult[index] = iterator ;
               index++;
            }

            iterator++;
        }


    }

    public static String calcOddNumbersFromTo(int floorLimit, int topLimit){
        String oddNumbers = "";
        int iterator = floorLimit;

        while (iterator <= topLimit){
            if (iterator % 2 != 0){
                oddNumbers = oddNumbers + ", " + iterator + " ";
            }
            iterator++;
        }

        oddNumbers = oddNumbers.replaceFirst(",", "");
        oddNumbers = "Los numeros impares del"+ floorLimit +" hasta " + topLimit + " son -> " + oddNumbers;

        return oddNumbers;
    }

    public static String calcCousinNumbersFromTo(int floorLimit, int topLimit){
        String primeNumbers = "";
        boolean isPrime;
        int iterator = floorLimit;

        while (iterator <= topLimit){
            isPrime = true;
            if(iterator <= 1){
                isPrime = false;
            }else{
                for (int count = 2; count < iterator; count++){
                    if(iterator % count == 0){
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime){
                primeNumbers = primeNumbers + ", " + iterator + " ";
            }
            iterator++;
        }

        primeNumbers = primeNumbers.replaceFirst(",", "");
        primeNumbers = "Los numeros primos del "+ floorLimit + " al " + topLimit + " son ->" + primeNumbers;

        return primeNumbers;
    }
}
