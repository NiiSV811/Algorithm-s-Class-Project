package essentials.view;

import essentials.controller.Parser;
import essentials.model.Utilities;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
         Utilities util = new Utilities();
         Parser controller = new Parser();
         String[] options = new String[]{"Sucesión Fibonacci", "Digitos [0-9]", "Numeros [0-10]", "Pares [1-10]", "Impares [1-10]", "Verificador Capicúa", "Salir"};
         int menuOption = 0;
         int exitFlag = 1;
         int auxiliarInt = 0;
         String capicuaInput = "";
         String response = "";


         while (exitFlag != 0){
             menuOption = JOptionPane.showOptionDialog(null, "Menú: Selecciona utilidad ", "Utilidades",JOptionPane.DEFAULT_OPTION,
                     JOptionPane.QUESTION_MESSAGE, null, options, options[0] );
             switch (menuOption){
                 case 0://Fibonacci
                     auxiliarInt = controller.StringToInt("Ingresa el número de posiciones para hallar en la sucesión de Fibonacci (Enteros mayores a 0)");
                     response = util.FibonacciSequence(auxiliarInt);
                     break;
                 case 1:// Digits
                     response = util.NaturalNumbers();
                     break;
                 case 2:// [0-10]
                     response = util.NumbersToTen();
                     break;
                 case 3://Evens
                     response = util.EvenNums();
                     break;
                 case 4: //Odds
                     response = util.OddNums();
                     break;
                 case 5: //Capicua
                     capicuaInput = JOptionPane.showInputDialog("Ingrese palabra para comprobar si es capicúa :");
                     response = util.IsCapicua(capicuaInput);
                     break;
                 case 6:
                     exitFlag = JOptionPane.showConfirmDialog(null, "¿Desea Salir?");
                     response = "Gracias por usar las Utilidades de Rem";
                     break;
             }

             if(menuOption != 6){
                 JOptionPane.showMessageDialog(null, new JTextArea(response));
                 exitFlag = JOptionPane.showConfirmDialog(null, "¿Desea Salir?");
                 response = "Gracias por usar las Utilidades de Rem";
             }

         }
        JOptionPane.showMessageDialog(null, new JTextArea(response));

    }
}
