package LABA2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherGUI extends JFrame {
    private JButton buttonTellLecture = new JButton("Провести лекцию");
    private JButton buttonCheckStudentsFromHeadman = new JButton("Отметить старосту");
    private JButton buttonCheckStudent = new JButton("Проверить студетов");
    private JLabel labelIndicator = new JLabel("Вы пока не провели лекцию");
    private ArrayList<Lecture> listExercise = new ArrayList<Lecture>();
    private ArrayList<Student> listOfStudent = new ArrayList<Student>();
    private University university;
    private JComboBox<String> comboBoxLectures = new JComboBox<String>();
    private JComboBox<String> comboBoxStudents = new JComboBox<String>();


    public TeacherGUI(University university){
        super("Teacher");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 475, 125);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.university = university;
        this.listExercise = university.getLecture();
        this.listOfStudent = university.getStudents();

        StudentGUI.addLectures(this.listExercise,this.comboBoxLectures);


        Container containerTeacher = this.getContentPane();//содержит все поля
        containerTeacher.setLayout(new GridLayout(3,0,5,5));
        containerTeacher.add(comboBoxLectures);
        containerTeacher.add(labelIndicator);
        containerTeacher.add(buttonTellLecture);
        containerTeacher.add(buttonCheckStudent);
        containerTeacher.add(buttonCheckStudentsFromHeadman);
        containerTeacher.add(comboBoxStudents);

        buttonTellLecture.addActionListener(new ButtonShowLecturesEvent());
        buttonCheckStudent.addActionListener(new ButtonShowStudentsEvent());
        buttonCheckStudentsFromHeadman.addActionListener(new ButtonShowHeadmanEvent());
    }

    class ButtonShowLecturesEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            labelIndicator.setText("Ура! вы провели :" + comboBoxLectures.getSelectedItem());
        }
    }

    class ButtonShowStudentsEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            HeadmanGUI.addStudents(listOfStudent,comboBoxStudents);
        }
    }

    class ButtonShowHeadmanEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            HeadmanGUI.addMe(university.getHeadman().getHeadman(),comboBoxStudents);
        }
    }
}
