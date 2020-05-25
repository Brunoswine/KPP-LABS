package LABA2;
import java.util.ArrayList;


public class Student {

    private String name = new String();
    private String surname = new String();
    private String marks = new String();

    public Student(){;}
    public Student(String name,String surname,String mark){
        this.name = name;
        this.surname = surname;
        this.marks = mark;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return  this.surname;
    }


    public String getMarks(){
        return this.marks;
    }

    public void setName(String name){
        this.name = name;
    }

    public  void setSurname(String surname){
        this.surname = surname;
    }

    public void setMarks(String mark){
        this.marks += "|" + mark;
    }

    public int visitLecture(Lecture lecture){
        return 0;
    }

    public void setStudent(Student student) {
        this.name = student.name;
        this.surname = student.surname;
    }

    public String retThanks(){ return "Thank u";}
}


