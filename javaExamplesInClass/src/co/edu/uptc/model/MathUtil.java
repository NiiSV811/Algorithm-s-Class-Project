package co.edu.uptc.model;

public class MathUtil {

    public static String calcEvenNumbers(int limit){
        String evenNums = "";
        int iterator = 0;
        while (iterator <=limit ){

            if (iterator%2 == 0){
                evenNums = evenNums + ", " + iterator + " ";
            }

            iterator++;
        }

        evenNums = evenNums.replaceFirst(",", "");
        evenNums = "Los numeros pares de 0 hasta " + limit +" son ->"+ evenNums;

        return evenNums;
    }

    public static String calcOddNumbers(int limit){
        String oddNumbers = "";
        int iterator = 0;

        while (iterator <= limit){
            if (iterator % 2 != 0){
                oddNumbers = oddNumbers + ", " + iterator + " ";
            }
            iterator++;
        }

        oddNumbers = oddNumbers.replaceFirst(",", "");
        oddNumbers = "Los numeros impares del 0 hasta " + limit + " son -> " + oddNumbers;

        return oddNumbers;

    }

    public static String calcCousinNumbers(int limit){
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
                primeNumbers = primeNumbers + ", " + iterator + " ";
            }
            iterator++;
        }

        primeNumbers = primeNumbers.replaceFirst(",", "");
        primeNumbers = "Los numeros primos del 0 al " + limit + " son ->" + primeNumbers;

        return primeNumbers;
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

    public static String calcEvenNumbersFromTo(int floorLimit, int topLimit){
        String evenNums = "";
        int iterator = floorLimit;
        while (iterator <= topLimit ){

            if (iterator%2 == 0){
                evenNums = evenNums + ", " + iterator + " ";
            }

            iterator++;
        }

        evenNums = evenNums.replaceFirst(",", "");
        evenNums = "Los numeros pares de "+ floorLimit +" hasta " + topLimit +" son ->"+ evenNums;

        return evenNums;

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
