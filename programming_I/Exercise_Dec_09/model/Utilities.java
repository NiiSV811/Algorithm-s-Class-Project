package essentials.model;

public class Utilities {

    //Fibonacci
    public  String FibonacciSequence(int times){
        String fibonacciSequence = "";
        long prev1 = 0;
        long prev2 = 1;
        long lastFibonacci = 0;

        if(times == 1){
            fibonacciSequence = "El primer digito de la sucesión Fibonacci es \n" + prev1 ;
            return fibonacciSequence;
        }
        if(times == 2){
            fibonacciSequence = "Los primeros dos digitos de la sucesión Fibonacci son: \n" + prev1 + "   " + prev2;
            return fibonacciSequence;
        }

        fibonacciSequence = "Los primeros " + times + " digitos de la sucesión fibonacci son: \n\t" + prev1 + "\t" + prev2 + "\n";
        for(int t = 0; t < (times - 2); t++){
            lastFibonacci = prev2 + prev1;
            fibonacciSequence += "\t" + lastFibonacci;

            prev1 = prev2;
            prev2 = lastFibonacci;

            if(t % 2 != 0){
                fibonacciSequence += "\n";
            }
        }
        return fibonacciSequence;
    }

    //Numbers 0 - 9
    public String NaturalNumbers(){
        String numbers = "";
        numbers = "Los digitos numéricos son: \n    ";
        for(int n = 0; n < 10; n++){
            if( n == 0){
                numbers += "  ";
            }
            numbers += "  " + n;
            if( n % 3 == 0){
                numbers += "\n  ";
            }
        }
        return numbers;
    }

    //Numbers 0 - 10
    public String NumbersToTen(){
        String numbers = "";
        numbers = "Los primeros 10 números son: \n    ";
        for(int n = 0; n <= 10; n++){
            numbers += "  " + n;
            if( (n % 3 == 0 && n != 0) || n == 8){
                numbers += "\n    ";
            }
        }
        return numbers;
    }

    //Even Numbers
    public String EvenNums(){
        String evens = "";
        evens = "Los pares del 1 hasta el 10 son: \n[";
        for(int even = 1; even <= 10; even++){
            evens += (even % 2 == 0) ? even : ", ";
        }
        evens = evens.replaceFirst("," , "");
        evens += " ]";
        return evens;
    }

    //Odds Nums
    public String OddNums(){
        String odds = "";
        odds = "Los impares del 1 al 10 son: \n[ ";
        for(int odd = 1; odd <= 10; odd++){
            odds += (odd % 2 != 0) ? odd : ", ";
        }
        odds = odds.substring(0,odds.length()-2);
        odds += " ]";

        return odds;
    }

    //Capicúa
    public String IsCapicua(String foo){
        String fooLower = "";
        String inverseFoo = "";
        String result = "";

        fooLower =foo.toLowerCase();
        for(int c = foo.length()-1; c >= 0; c--){
            inverseFoo += fooLower.charAt(c);
        }
        System.out.println(inverseFoo);

        result = inverseFoo.equals(fooLower)? foo + " Es capicúa :)": foo + " No es capicúa";
        return result ;
    }
}
