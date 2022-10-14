package greeting;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        //Auxiliar Variables
        String auxAge = "";
        String auxGenre = "";

        // Variables to Set
        int age = 0;
        String name = "";
        boolean genre = false;

        Person lulu = new Person();

        //Input
        name = JOptionPane.showInputDialog("Ingresa nombre: ");
        auxAge = JOptionPane.showInputDialog("Ingresa Edad : ");
        auxGenre = JOptionPane.showInputDialog("Ingresa Género: \n true: M \nfalse: F ");

        //Casting
        age = Integer.parseInt(auxAge);
        genre = Boolean.parseBoolean(auxGenre);

        //Setting




    }




    }
}
