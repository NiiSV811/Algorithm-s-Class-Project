package co.edu.uptc.view;

import co.edu.uptc.model.MathUtil;

import javax.swing.*;
import java.text.ParseException;

public class View {
    public static void main(String[] args) {

        int limit , floorLimit , topLimit = 0;
        String numCapicuaCheck , auxLimit,auxFloor, auxTop = "";

        auxLimit = JOptionPane.showInputDialog("Calcular Numeros pares del 0 hasta: ");
        try {
            limit = Integer.parseInt(auxLimit);
            JOptionPane.showMessageDialog(null, MathUtil.calcEvenNumbers(limit));
        }catch (Exception ParseException){
            JOptionPane.showMessageDialog(null, "Valor incorrecto");
        }

        auxLimit = JOptionPane.showInputDialog("Calcular Numeros impares del 0 hasta: ");
        try {
            limit = Integer.parseInt(auxLimit);
            JOptionPane.showMessageDialog(null, MathUtil.calcOddNumbers(limit));
        }catch (Exception ParseException){
            JOptionPane.showMessageDialog(null, "Valor incorrecto");
        }

        auxLimit = JOptionPane.showInputDialog("Calcular Numeros primos del 0 hasta: ");
        try {
            limit = Integer.parseInt(auxLimit);
            JOptionPane.showMessageDialog(null, MathUtil.calcCousinNumbers(limit));
        }catch (Exception ParseException){
            JOptionPane.showMessageDialog(null, "Valor incorrecto");
        }

        numCapicuaCheck = JOptionPane.showInputDialog("Igrese numero para comprobar si es capicua: ");
        if(MathUtil.isCapicua(numCapicuaCheck)){
            JOptionPane.showMessageDialog(null, numCapicuaCheck + " Si es capicua");
        }else {
            JOptionPane.showMessageDialog(null, numCapicuaCheck + " NO es capicua");
        }

        auxFloor = JOptionPane.showInputDialog("Elija valor mínimo para calcular pares");
        auxTop = JOptionPane.showInputDialog("Elija valor máximo para calcular pares");

        try {
            floorLimit = Integer.parseInt(auxFloor);
            topLimit = Integer.parseInt(auxTop);

            JOptionPane.showMessageDialog(null, MathUtil.calcEvenNumbersFromTo(floorLimit, topLimit));

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Valores incorrectos :(");
        }

        auxFloor = JOptionPane.showInputDialog("Elija valor mínimo para calcular impares");
        auxTop = JOptionPane.showInputDialog("Elija valor máximo para calcular impares");

        try {
            floorLimit = Integer.parseInt(auxFloor);
            topLimit = Integer.parseInt(auxTop);

            JOptionPane.showMessageDialog(null, MathUtil.calcOddNumbersFromTo(floorLimit, topLimit));

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Valores incorrectos :(");
        }

        auxFloor = JOptionPane.showInputDialog("Elija valor mínimo para calcular primos");
        auxTop = JOptionPane.showInputDialog("Elija valor máximo para calcular primos ");

        try {
            floorLimit = Integer.parseInt(auxFloor);
            topLimit = Integer.parseInt(auxTop);

            JOptionPane.showMessageDialog(null, MathUtil.calcCousinNumbersFromTo(floorLimit, topLimit));

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Valores incorrectos :(");
        }

    }
}
