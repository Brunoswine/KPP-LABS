package LABA2;

public class Lecture extends Exercise{
    private String topic = new String();

    public Lecture(){;}

    public Lecture(String date,String topic){

        this.topic = topic;
        this.date = date;
    }

    public void setLecture (String newData,String newTopic){
        this.date = newData;
        this.topic = newTopic;
    }

    public String getTopic (){
        return this.topic;
    }
    public String getDate () {
        return this.date;
    }
    public String retKnowledge () { return "Вернуть знания"; }

}
