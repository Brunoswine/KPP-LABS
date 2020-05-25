package LABA3;
import java.util.ArrayList;


public class Student extends AbstractStudent {
    private String marks;

    public Student(){
        marks = new String();
    }
    public Student(String newName,String newSurname,String mark){
        super(newName,newSurname);
        marks = new String();
        this.marks = mark;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return  this.surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getMarks(){
        return this.marks;
    }

    public void setMarks(String mark){
        this.marks += "|" + mark;
    }


    public String retThanks(){ return "Thank u";}
}


