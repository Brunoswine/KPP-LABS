package LABA2;
import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Lecture> exercises = new ArrayList<Lecture>();
    private Headman headman = new Headman();

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
    public University(Teacher teacher,Student student,Exercise exercise){
        teachers.add(teacher);
    }

    public void enrollStudent(Student newStudent){
        this.students.add(newStudent);
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

    public Student getStudent(int pos){
        return students.get(pos);
    }

    public ArrayList<Lecture> getLecture(){
        return this.exercises;
    }

    public void setLecture(Lecture lecture){ this.exercises.add(lecture);}

    public void setTeachers(Teacher teacher){
        this.teachers.add(teacher);
    }

    public void setStudents(Student student) {this.students.add(student);}

    public ArrayList<Teacher> getTeachers(){return this.teachers;}

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Headman getHeadman() {
        return headman;
    }
}
