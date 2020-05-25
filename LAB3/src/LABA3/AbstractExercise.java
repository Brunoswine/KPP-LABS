package LABA3;

import java.util.ArrayList;

abstract class AbstractExercise {
    public String date;
    public String topic;

    public AbstractExercise(){;}
    public AbstractExercise(String date){
        this.date = date;
    }

    public abstract String getDate();

    public abstract void setDate(String date);

    public abstract ArrayList<AbstractStudent> getPresentStudents();

    public abstract void setLecture (String newData,String newTopic);

    public abstract String getTopic ();

    public abstract String retKnowledge ();

    public abstract String addPresentStudent(AbstractStudent student);



}
