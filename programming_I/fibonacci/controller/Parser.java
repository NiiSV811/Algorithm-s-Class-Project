package fibonacci.controller;

import javax.swing.*;

public class Parser {
    public int StringToInt(String message){
        String input = "";
        int stringNumber = 0;
        int exit = 0;

        while (exit != 1){

            input = JOptionPane.showInputDialog(message);
            try {
                stringNumber = Integer.parseInt(input);
                if(stringNumber > 0){
                    exit = 1;
                }else {
                    JOptionPane.showMessageDialog(null, "Valor inválido, vuélvelo a intentar. Números mayores a 0");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa un número mayor a 0");
            }

        }
        return stringNumber;
    }
}
