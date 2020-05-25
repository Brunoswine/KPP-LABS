package LABA3;
import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<AbstractStudent> students = new ArrayList<AbstractStudent>();
    private ArrayList<AbstractExercise> exercises = new ArrayList<AbstractExercise>();
    private Headman headman = new Headman();
    private Journal journal = new Journal(students);

    public University(){
        teachers.add(new Teacher("Юрий","Александрович"));
        teachers.add(new Teacher("Дмитрий","Юрьевич"));
        teachers.add(new Teacher("Наталья","Александрович"));
        exercises.add(new Lecture("19.05.2020","СПОВМ"));
        exercises.add(new Lecture("19.05.2020","КПП"));
        exercises.add(new Lecture("20.03.2020","АПК"));
        students.add(new Student("Иван","Якушев","8|8|"));
        students.add(new Student("Владислав","Юрчик","8|7"));
        students.add(new Student("Дарья","Минина","9|7"));
    }
    public University(Teacher teacher,Student student,AbstractExercise exercise,Journal journal){
        teachers.add(teacher);
    }

    public void enrollStudent(Student newStudent){
        this.students.add(new Student(newStudent.getName(),newStudent.getSurname(),"0"));
    }

    public void hireTeacher(Teacher newTeacher){
        this.teachers.add(newTeacher);
    }

    public void makePlanLectures(Lecture newExercise){
        this.exercises.add(newExercise);
    }

    public int getCountOfStudents(){
        return students.size();
    }

    public AbstractStudent getStudent(int pos){
        return students.get(pos);
    }

    public ArrayList<AbstractExercise> getLecture(){
        return this.exercises;
    }

    public void setLecture(Lecture lecture){ this.exercises.add(lecture);}

    public void setTeachers(Teacher teacher){
        this.teachers.add(teacher);
    }

    public void setStudents(Student student) {this.students.add(student);}

    public ArrayList<Teacher> getTeachers(){return this.teachers;}

    public ArrayList<AbstractStudent> getStudents() {
        return this.students;
    }

    public Headman getHeadman() {
        return headman;
    }

    public Journal getJournal(){
        return this.journal;
    }
}
