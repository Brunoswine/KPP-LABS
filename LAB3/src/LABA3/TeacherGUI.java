package LABA3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherGUI{
    private JButton buttonTellLecture;
    private JButton buttonCheckStudentsFromHeadman;
    private JButton buttonCheckStudent;
    private JButton buttonCMPListOfStudents;
    private JLabel labelIndicatorStudents;
    private JLabel labelIndicator;
    private ArrayList<AbstractExercise> listExercise;
    private Journal journal;
    private University university;
    private JComboBox<String> comboBoxLectures;
    private JComboBox<String> comboBoxStudents;


    public TeacherGUI(University university){
        buttonTellLecture = new JButton("Провести лекцию");
        buttonCheckStudentsFromHeadman = new JButton("Отметить старосту");
        buttonCheckStudent = new JButton("Проверить студетов");
        buttonCMPListOfStudents = new JButton("Сравнить списки");
        labelIndicatorStudents = new JLabel("Сравнение студентов");
        labelIndicator = new JLabel("Вы пока не провели лекцию");
        listExercise = new ArrayList<AbstractExercise>();
        comboBoxLectures = new JComboBox<String>();
        comboBoxStudents = new JComboBox<String>();

        this.university = university;
        this.journal = university.getJournal();
        this.listExercise = university.getLecture();

        StudentGUI.addLectures(this.listExercise,this.comboBoxLectures);
    }

    JFrame buildTeacherGUIFrame(){
        JFrame frame = new JFrame("Teacher");

        frame.setBounds(650, 250, 475, 175);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Container containerTeacher = frame.getContentPane();//содержит все поля
        containerTeacher.setLayout(new GridLayout(4,0,5,5));
        containerTeacher.add(comboBoxLectures);
        containerTeacher.add(labelIndicator);
        containerTeacher.add(buttonTellLecture);
        containerTeacher.add(buttonCheckStudent);
        containerTeacher.add(buttonCheckStudentsFromHeadman);
        containerTeacher.add(comboBoxStudents);
        containerTeacher.add(buttonCMPListOfStudents);
        containerTeacher.add(labelIndicatorStudents);

        buttonTellLecture.addActionListener(new ButtonShowLecturesEvent());
        buttonCheckStudent.addActionListener(new ButtonShowStudentsEvent());
        buttonCheckStudentsFromHeadman.addActionListener(new ButtonShowHeadmanEvent());
        buttonCMPListOfStudents.addActionListener(new ButtonCMPStudents());

        return frame;
    }

    class ButtonShowLecturesEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            labelIndicator.setText("Ура! вы провели :" + comboBoxLectures.getSelectedItem());
        }
    }

    class ButtonShowStudentsEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            ArrayList<AbstractStudent> listOfStudent = listExercise.get(comboBoxLectures.getSelectedIndex()).getPresentStudents();
            HeadmanGUI.addStudents(listOfStudent,comboBoxStudents);
            journal.setCheckedStudents(listOfStudent);
        }
    }

    class ButtonShowHeadmanEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            HeadmanGUI.addMe(university.getHeadman().getHeadman(),comboBoxStudents);
        }
    }

    class ButtonCMPStudents implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (university.getStudents().size() != 0 && journal.getListOfStudents().size() != 0) {
                if (university.getJournal().cmpPresentedStudents(journal.getListOfStudents()) == true) {
                    labelIndicatorStudents.setText("Всё в норме");
                    university.getHeadman().setResultOfCMP(true);
                } else {
                    labelIndicatorStudents.setText("Списки не равны");
                    university.getHeadman().setResultOfCMP(false);
                }
            }
        }
    }
}
