package personclass;

import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Person {

    // Attributes
    private int age;
    private boolean genre;
    private  String name;
    private String id;
    private String rh;
    private float height;
    private float weight;
    private LocalDate bornDate;
    private boolean married;
    private String skinColor;
    


    //Constructor
    public Person(){
        this.age = 0;
        this.genre = false;
        this.name = "";
        this.id = "";
        this.rh = "";
        this.height = 0;
        this.weight = 0;
        this.bornDate = LocalDate.now();
        this.married = false;
        this.skinColor = "";
    }

    //Methods
        //Setting Methods
        

    public void setGenre(boolean genre){
        this.genre = genre;
    }
    public void setName( String name){
        this.name = name;
    }

    public void setId( String id){
        this.id = id;
    }

    public void setRh( String rh){
        this.rh = rh;
    }

    public void setHeight( float height){
        this.height = height;
    }

    public void setWeigth( float weight){
        this.weight = weight;
    }

    public void setBornDate( LocalDate bornDate){
        this.bornDate = bornDate;
    }

    public void setMarried( boolean married){
        this.married = married;
    }

    public void setSkinColor( String skinColor){
        this.skinColor = skinColor;
    }

    public void setAge(){

        LocalDate actualDate = LocalDate.now();
        Period differentialYears = this.bornDate.until(actualDate);
        this.age = differentialYears.getYears();

    }

        //Get methods


    public boolean getGenre(){
        return this.genre;
    }

    public int getAge(){return this.age;}

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getRh(){
        return this.rh;
    }

    public float getHeight(){
        return this.height;
    }

    public float getWeight(){
        return this.weight;
    }

    public LocalDate getBornDate(){
        return this.bornDate;
    }

    public boolean getMarried(){
        return this.married;
    }

    public String getSkinColor(){
        return this.skinColor;
    }


    //Person Methods

    public boolean isGreaterThan18(){
       if (this.age >= 18){
           return true;
       }
       return false;
    }

}
