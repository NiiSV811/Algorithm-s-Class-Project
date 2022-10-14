package greeting;

public class Person {

    // Attributes
    private int age;
    private boolean genre;
    private  String name;
    //id(str), rh, height, weight, bornDate(Date) , married(boolean) , skinColor


    //Constructor
    public Person(){
        this.age = 0;
        this.genre = false;
        this.name = "";
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





}
