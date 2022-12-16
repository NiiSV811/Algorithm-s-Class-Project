package fibonacci.view;

import fibonacci.controller.Parser;
import fibonacci.model.Fibonacci;

import javax.swing.*;
import java.util.Arrays;

public class View {
    public static void main(String[] args) {
        Fibonacci myFibonacci = new Fibonacci();
        Parser myParser = new Parser();
        long[] resultFibonacci;
        int times = 0;
        String fibonacciResult = "";

        times = myParser.StringToInt("Fibonacci: Ingresa un número del 1 hasta donde quieras para calcular la sucesión");

        myFibonacci.setLimitFibonacci(times);
        myFibonacci.setFibonacciNums();

        resultFibonacci = myFibonacci.calculateFibonacci();
        JOptionPane.showMessageDialog(null, "Array \n" + Arrays.toString(resultFibonacci));


        fibonacciResult = myFibonacci.fibonacciToString();
        JOptionPane.showMessageDialog(null, fibonacciResult + "\nString");
    }
}
