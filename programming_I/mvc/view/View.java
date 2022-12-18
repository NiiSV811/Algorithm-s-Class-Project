package mvc.view;

import mvc.controller.Controller;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
        Controller controller = new Controller();
        String menu = "";
        String menuOption = "";
        String secondArg = "";
        String result = "";
        String status = "";
        String secondPrompt = "";

        menu = "1. Sucesión Fibonacci \n2. Digitos \n3. Numeros hasta el 10 \n4. Pares hasta el 10 \n5. Impares hasta el 10 \n6. Verificador de palindromos \n0. Salir";

        do {
            menuOption = JOptionPane.showInputDialog(menu + "\nIngresa valor del Menú");
            status = controller.menuValidator(menuOption);
            if(status.charAt(0) == 'N'){
                JOptionPane.showMessageDialog(null, status + ". Vuelvelo a intentar :)");
            }
        }while (status.charAt(0) == 'N');

        if(status.charAt(0) == 'G'){
            JOptionPane.showMessageDialog(null, status);
            return;
        }
        secondPrompt = status;
        while (status.charAt(0) == 'C'){
            secondArg = JOptionPane.showInputDialog("Ingresa palabra o numero para comprobar si es Capicúa");
            status = controller.CapicuaValidator(secondArg);
            if(status.charAt(1) == '1'){
                JOptionPane.showMessageDialog(null, "Debes ingresar una palabra o número");
            }
        }
        while (status.charAt(0) != ' '){
            secondArg = JOptionPane.showInputDialog("Ingresa el valor limite para " + secondPrompt);
            status = controller.secondArgValidator(secondArg);
            if(status.charAt(0) == 'N'){
                JOptionPane.showMessageDialog(null, status + ". Vuelvelo a intentar :)");
            }
        }


        result = controller.applyFunctions(menuOption, secondArg);
        JOptionPane.showMessageDialog(null, result);




    }

}
