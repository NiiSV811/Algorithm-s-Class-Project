package basicexamples;

import javax.swing.*;

public class Proof {

    public static void main(String[] args) {

        //Auxiliary Variables
        String genreAux = "";
        String ageAux = "";

        //Main Variables
        String name = "";
        int age = 0;
        boolean genre = true;

        //Inputs
        name = JOptionPane.showInputDialog("¿Cuál es tu nombre? ");
        ageAux = JOptionPane.showInputDialog("¿Cuál es tu Edad? ");
        genreAux = JOptionPane.showInputDialog("¿Cuál es tu género? M: true F: false ");


        //Casting
        age = Integer.parseInt(ageAux);
        genre = Boolean.parseBoolean(genreAux);

        JOptionPane.showMessageDialog(null, "Hola : " + name + "\n" +
        "Tu edad es: " + age + "\n" + "Tu genero es F : " + !genre);



    }

}
