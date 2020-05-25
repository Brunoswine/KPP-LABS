package LABA3;

import java.util.ArrayList;

public class Journal {
    private RowOfJournal row;
    private ArrayList<AbstractStudent> checkedStudents;
    private ArrayList<AbstractStudent > allStudent;

    public Journal(ArrayList<AbstractStudent> students){
        row = new RowOfJournal();
        this.allStudent = students;
    }

    public void checkStudent(ArrayList<AbstractStudent> students){
        row.addPresent(students);
    }

    public void notPresentStudent(Student student){
        row.notPresent(student.getSurname());
    }

    public ArrayList<AbstractStudent> getListOfStudents(){
        return this.checkedStudents;
    }

    public boolean cmpPresentedStudents(ArrayList<AbstractStudent> checkedStudents){
        int amount=0;
        this.checkedStudents = checkedStudents;
        for(int i = 0; i<allStudent.size();i++)
            for(int j = 0;j<checkedStudents.size();j++){
                if (allStudent.get(i).getSurname() == checkedStudents.get(j).getSurname())
                        amount++;
            }
        if(amount == allStudent.size()) return true;
        else return false;
    }

    public ArrayList<AbstractStudent> addNotPresentedStudentsToList(ArrayList<AbstractStudent> checkedStudents){
        this.checkedStudents = checkedStudents;
        for(int i = checkedStudents.size(); i < allStudent.size();i++){
            checkedStudents.add(new Student());
            checkedStudents.get(i).setSurname(allStudent.get(i).getSurname());
        }
        return checkedStudents;
    }

    public void setCheckedStudents(ArrayList<AbstractStudent> listOfStudent){
        this.checkedStudents = listOfStudent;
    }

    public RowOfJournal getRow(){
        return row;
    }
}
