package LABA3;

import java.util.ArrayList;

public class Lecture extends AbstractExercise{
    private ArrayList<AbstractStudent> presentStudents = new ArrayList<AbstractStudent>();

    public Lecture(){;}

    public Lecture(String date,String topic){
        super(date);
        this.topic = topic;
    }

    public void setLecture (String newData,String newTopic){
        this.setDate(newData);
        this.topic = newTopic;
    }

    public String getTopic (){
        return this.topic;
    }
    public String retKnowledge () { return "Вернуть знания"; }
    public String addPresentStudent(AbstractStudent student){
        presentStudents.add(student);
        return retKnowledge();
    }

    public ArrayList<AbstractStudent> getPresentStudents(){
        return presentStudents;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

}
