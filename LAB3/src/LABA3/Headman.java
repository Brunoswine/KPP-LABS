package LABA3;

import java.util.ArrayList;

public class Headman extends  Student {
    private Student headman = new Student();
    public boolean resultOfCMP = true;
    ArrayList<AbstractStudent> checkedStudent = new ArrayList<AbstractStudent>();

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

    public void addStudentsToJournal(ArrayList<AbstractStudent> students, Journal journal){
        journal.checkStudent(students);
    }

    public void setResultOfCMP(boolean bool){
        if (bool == true) this.resultOfCMP = true;
        else this.resultOfCMP = false;
    }

    public void addNotPresentedStudent(){

    }

}
