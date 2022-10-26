package personclass;

import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        //Auxiliary Variables

        String auxAge = "";
        String auxGenre = "";
        String auxHeight = "";
        String auxWeight = "";
        String auxDate = "";
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String auxMarried = "";

        // Variables to Set
        int age = 0;
        String name = "";
        boolean genre = false;
        String id = "";
        String rh = "";
        float height = 0;
        float weight = 0;
        LocalDate bornDate = null;
        boolean married = false;
        String skinColor = "";


        Person lulu = new Person();

        //Input
        name = JOptionPane.showInputDialog(null, "Ingresa nombre: ", "Jonh Doe");
        auxGenre = JOptionPane.showInputDialog(null, "Ingresa Género: \n true: M \nfalse: F ", "false");
        id = JOptionPane.showInputDialog(null, "Ingresa id : ", "T.I 1054262632");
        rh = JOptionPane.showInputDialog(null,"Ingresa RH : ", "O+");
        auxHeight = JOptionPane.showInputDialog(null, "Ingresa altura (metros): ", "1.59");
        auxWeight = JOptionPane.showInputDialog(null, "Ingresa peso (kilogramos)", "60");
        auxDate = JOptionPane.showInputDialog(null,"Ingresa edad de nacimiento: ", "01/01/2001");
        auxMarried = JOptionPane.showInputDialog(null,"Ingrese estado casado: \n Casado: true \n Soltero: false","false");
        skinColor = JOptionPane.showInputDialog(null, "Ingresa tonalidad de piel: ","moren@");


        //Casting
        try {
            genre = Boolean.parseBoolean(auxGenre);
            height = Float.parseFloat(auxHeight);
            weight = Float.parseFloat(auxWeight);
            bornDate = LocalDate.parse(auxDate, pattern);
            married = Boolean.parseBoolean(auxMarried);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Entrada no valida X(... Vuelve a intentarlo");
            System.exit(0);
        }

        //Setting

        lulu.setName(name);
        lulu.setGenre(genre);
        lulu.setId(id);
        lulu.setRh(rh);
        lulu.setHeight(height);
        lulu.setWeigth(weight);
        lulu.setBornDate(bornDate);
        lulu.setMarried(married);
        lulu.setSkinColor(skinColor);
        lulu.setAge();

        //Showing person attributes
        JOptionPane.showMessageDialog(null,"Los atributos de "
                + lulu.getName() + " son: " +
                "\n Nombre: " + lulu.getName() +
                "\n Id: " + lulu.getId()+
                "\n Edad: " + lulu.getAge() + " años" +
                "\n " + lulu.getName()+ " es mayor de edad? : " + lulu.isGreaterThan18() +
                "\n Genero: " + lulu.getGenre() + "        false: F  true: M" +
                "\n RH: " + lulu.getRh()+
                "\n Estatura: " + lulu.getHeight() + "    metros" +
                "\n Peso: " + lulu.getWeight() + "     Kilogramos " +
                "\n Fecha Nacimiento : " + lulu.getBornDate().format(pattern) +
                "\n Casad@? : " + lulu.getMarried() +
                "\n Color de tez : " + lulu.getSkinColor()
        );






    }

}

