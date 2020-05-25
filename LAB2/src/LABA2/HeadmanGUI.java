package LABA2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HeadmanGUI extends StudentGUI {
    private JButton buttonCheckStudents = new JButton("Проверка студентов");
    private JButton buttonCheckMe = new JButton("Отметить себя");
    private JComboBox<String> comboBox = new JComboBox<String>();
    private University university;

    public static void addStudents(ArrayList<Student> students, JComboBox<String> comboBox){
        for (int i = 0; i < students.size(); i++) {
            comboBox.addItem(students.get(i).getName() + " " + students.get(i).getSurname());
        }
    }

    public static void addMe(Student headman,JComboBox<String> comboBox){
        comboBox.addItem(headman.getName() + " " + headman.getSurname());
    }

    public HeadmanGUI(University university){
        super(university);//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 450, 125);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.university = university;

        Container containerStudent = this.getContentPane();//содержит все поля
        containerStudent.setLayout(new GridLayout(3,0,5,5));
        containerStudent.add(buttonCheckStudents);
        containerStudent.add(buttonCheckMe);
        containerStudent.add(comboBox);

        buttonCheckStudents.addActionListener(new ButtonCheckStudents());
        buttonCheckMe.addActionListener(new ButtonCheckMe());
    }

    class ButtonCheckStudents implements ActionListener {
        public void actionPerformed (ActionEvent e){
            addStudents(university.getStudents(),comboBox);
            for(int i = 0; i < university.getStudents().size();i++)
                university.getStudents().get(i).retThanks();
        }
    }

    class ButtonCheckMe implements ActionListener {
        public void actionPerformed (ActionEvent e){
            addMe(university.getHeadman().getHeadman(),comboBox);
        }
    }

}
