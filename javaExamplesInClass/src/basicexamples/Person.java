package personclass;

import java.util.Date;

public class Person {

    // Attributes
    private int age;
    private boolean genre;
    private  String name;
    private String id;
    private String rh;
    private float height;
    private float weight;
    private Date bornDate;
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
        this.bornDate = new Date();
        this.married = false;
        this.skinColor = "";
    }

    //Methods
        //Setting Methods
        
    public void setAge(int age){
        this.age = age;
    }
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

    public void setBornDate( Date bornDate){
        this.bornDate = bornDate;
    }

    public void setMarried( boolean married){
        this.married = married;
    }

    public void setSkinColor( String skinColor){
        this.skinColor = skinColor;
    }


        //Get methods
    public int getAge(){
        return this.age;
    }

    public boolean getGenre(){
        return this.genre;
    }

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

    public Date getBornDate(){
        return this.bornDate;
    }

    public boolean getMarried(){
        return this.married;
    }

    public String getSkinColor(){
        return this.skinColor;
    }

}
