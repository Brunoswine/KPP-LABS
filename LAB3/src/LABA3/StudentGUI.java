package LABA3;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGUI extends JFrame {

    private JButton buttonUniversity;
    private JComboBox<String> comboBox;
    private JLabel labelIndicator;
    private University university;

    public static void addLectures(ArrayList<AbstractExercise> lecture,JComboBox<String> comboBox){

            for (int i = 0; i < lecture.size(); i++) {
                comboBox.addItem(lecture.get(i).getTopic() + " " + lecture.get(i).getDate());
            }

    }

    public JComboBox<String> getCombobox(){
        return this.comboBox;
    }

    public StudentGUI(){}
    public StudentGUI(University university){
        super("Student");
        buttonUniversity = new JButton("Посетить лекцию");
        comboBox = new JComboBox<String>();
        labelIndicator = new JLabel("Вы пока не сходили на лекцию");


        this.setBounds(650, 250, 450, 125);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.university = university;



        Container containerStudent = this.getContentPane();
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
            university.getJournal().checkStudent(university.getStudents());
            for(int i = 0; i<university.getStudents().size();i++)
                university.getLecture().get(comboBox.getSelectedIndex()).addPresentStudent(university.getStudents().get(i));
        }
    }


}
