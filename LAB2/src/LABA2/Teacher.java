package LABA2;

import java.util.ArrayList;

public class Teacher {
    private String name = new String();
    private String surname = new String();

    ArrayList<Student> checkedStudent = new ArrayList<Student>();

    public Teacher(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public int readLecture(Lecture lecture){
        return 0;
    }

    public void checkStudent(University allStudents,Student student){
        for(int i = 0; i < allStudents.getCountOfStudents();i++){
            if(student.getName() == allStudents.getStudent(i).getName() && student.getSurname() == allStudents.getStudent(i).getSurname())
                checkedStudent.add(student);
        }
    }

    public void setInfo(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getInfo(){
        return this.name + " " + this.surname;
    }
    public String getName() { return this.name; }
    public String getSurname() { return  this.surname; }
}
