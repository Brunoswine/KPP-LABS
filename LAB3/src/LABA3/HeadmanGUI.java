package LABA3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HeadmanGUI extends StudentGUI {
    private JButton buttonCheckStudents;
    private JButton buttonCheckMe;
    private JButton buttonCheckNotPresentedStudents;
    private JComboBox<String> comboBox;
    private University university;

    public static void addStudents(ArrayList<AbstractStudent> students, JComboBox<String> comboBox){
        comboBox.removeAllItems();
        for (int i = 0; i < students.size(); i++) {
            comboBox.addItem(students.get(i).getSurname());
        }
    }

    public static void addMe(Student headman,JComboBox<String> comboBox){
        comboBox.addItem(headman.getName() + " " + headman.getSurname());
    }

    public HeadmanGUI(University university){
        super(university);

        buttonCheckStudents = new JButton("Проверка студентов");
        buttonCheckMe = new JButton("Отметить себя");
        buttonCheckNotPresentedStudents = new JButton("Отметить отсутсвие");
        comboBox = new JComboBox<String>();

        this.setBounds(650, 250, 450, 150);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.university = university;

        Container containerStudent = this.getContentPane();
        containerStudent.setLayout(new GridLayout(4,0,5,5));
        containerStudent.add(buttonCheckStudents);
        containerStudent.add(buttonCheckMe);
        containerStudent.add(comboBox);
        containerStudent.add(buttonCheckNotPresentedStudents);

        buttonCheckStudents.addActionListener(new ButtonCheckStudents());
        buttonCheckMe.addActionListener(new ButtonCheckMe());
        buttonCheckNotPresentedStudents.addActionListener(new ButtonAddNotPresentedStudents());
    }

    class ButtonCheckStudents implements ActionListener {
        public void actionPerformed (ActionEvent e){
            JComboBox<String> tmpComboBox = getCombobox();
            ArrayList<AbstractStudent> tmpPresentedStudents;
            tmpPresentedStudents = university.getLecture().get(tmpComboBox.getSelectedIndex()).getPresentStudents();
            addStudents(tmpPresentedStudents,comboBox);
            for(int i = 0; i < tmpPresentedStudents.size();i++)
                tmpPresentedStudents.get(i).retThanks();
        }
    }

    class ButtonCheckMe implements ActionListener {
        public void actionPerformed (ActionEvent e){
            addMe(university.getHeadman().getHeadman(),comboBox);
        }
    }

    class ButtonAddNotPresentedStudents implements ActionListener {
        public void actionPerformed (ActionEvent e){
            ArrayList<AbstractStudent> listOfStudents = university.getJournal().addNotPresentedStudentsToList(university.getJournal().getListOfStudents());
            comboBox.removeAllItems();
            addStudents(listOfStudents,comboBox);
        }
    }

}
