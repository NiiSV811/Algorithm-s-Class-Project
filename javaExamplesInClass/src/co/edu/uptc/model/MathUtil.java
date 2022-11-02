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


}
