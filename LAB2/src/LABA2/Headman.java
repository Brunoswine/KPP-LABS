package LABA2;

import java.util.ArrayList;

public class Headman extends  Student {
    private Student headman = new Student();
    ArrayList<Student> checkedStudent = new ArrayList<Student>();

    public Headman(){
        headman.setName("Староста");
        headman.setSurname("Потока");
        headman.setMarks("10|10");
    }

    public Headman(String name,String surname){
        new Student(name,surname,"0");
    }

    public Student getHeadman(){
        return headman;
    }
}
