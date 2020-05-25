package LABA2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGUI extends JFrame {

    private JButton buttonUniversity = new JButton("Посетить лекцию");
    private JComboBox<String> comboBox = new JComboBox<String>();
    private JLabel labelIndicator = new JLabel("Вы пока не сходили на лекцию");
    private University university;

    public static void addLectures(ArrayList<Lecture> lecture,JComboBox<String> comboBox){

            for (int i = 0; i < lecture.size(); i++) {
                comboBox.addItem(lecture.get(i).getTopic() + " " + lecture.get(i).getDate());
            }

    }

    public StudentGUI(){}
    public StudentGUI(University university){
        super("Student");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 450, 125);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.university = university;



        Container containerStudent = this.getContentPane();//содержит все поля
        containerStudent.setLayout(new GridLayout(2,0,5,5));
        addLectures(university.getLecture(),comboBox);
        containerStudent.add(comboBox);
        containerStudent.add(labelIndicator);
        containerStudent.add(buttonUniversity);


        buttonUniversity.addActionListener(new ButtonShowLecturesEvent());
    }

    class ButtonShowLecturesEvent implements ActionListener {
        public void actionPerformed (ActionEvent e){
            labelIndicator.setText(university.getLecture().get(comboBox.getComponentCount()).retKnowledge() + " " +
                                    comboBox.getSelectedItem());
        }
    }
}
