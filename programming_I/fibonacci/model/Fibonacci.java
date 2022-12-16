package fibonacci.model;

public class Fibonacci {
    //Atributes
    long[] fibonacciNums;
    int limitFibonacci;
    String fibonacciResult;

    public Fibonacci(){
        this.limitFibonacci = 0;
        this.fibonacciResult = "";
    }

    //set methods
    public void setLimitFibonacci(int limitFibonacci){
        this.limitFibonacci = limitFibonacci;
    }
    public void setFibonacciNums(){
        this.fibonacciNums = new long[this.limitFibonacci];
    }
    public void setFibonacciResult(String result){
        this.fibonacciResult = result;
    }

    //get methods
    public int getLimitFibonacci(){
        return this.limitFibonacci;
    }
    public long[] getFibonacciNums(){
        return this.fibonacciNums;
    }
    public String getFibonacciResult(){
        return this.fibonacciResult;
    }


    //Methods
    public long[] calculateFibonacci(){
        fibonacciNums[0] = 0;
        if(this.limitFibonacci == 1){
            return this.fibonacciNums;
        }
        fibonacciNums[1] = 1;
        if (this.limitFibonacci == 2){
            return this.fibonacciNums;
        }

        for(int fib = 2; fib < this.limitFibonacci; fib++){
            this.fibonacciNums[fib] = this.fibonacciNums[fib - 2] + this.fibonacciNums[fib - 1] ;
        }

        return this.fibonacciNums;
    }

    public String fibonacciToString(){
        long[] fibonacciSerie = calculateFibonacci();
        this.fibonacciResult += "Las primeras " + this.limitFibonacci + " posiciones de la Serie Fibonacci son: \n";
        this.fibonacciResult += "[ ";
        for(int numIndex = 0; numIndex < fibonacciSerie.length; numIndex++){
            this.fibonacciResult += fibonacciSerie[numIndex];
            this.fibonacciResult += numIndex == (fibonacciSerie.length -1)? "" : " , ";
        }
        this.fibonacciResult += " ]";
        return this.fibonacciResult;
    }
}
