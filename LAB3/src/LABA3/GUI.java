package LABA3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI{
    private JButton buttonUniversity;
    private JButton buttonStudent;
    private JButton buttonTeacher;
    private JButton buttonHeadman;
    private University university;

    public GUI () {
        university = new University();
        buttonHeadman = new JButton("Меню старосты");
        buttonTeacher = new JButton("Меню преподователя");
        buttonStudent = new JButton("Меню студента");
        buttonUniversity = new JButton("Меню Университета");
    }

    JFrame buildGUIFrame(){
        JFrame frame = new JFrame("Third lab");
        frame.setBounds(650, 250, 425, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();//содержит все поля
        container.setLayout(new GridLayout(4,0,5,5));
        container.add(buttonUniversity);
        container.add(buttonTeacher);
        container.add(buttonStudent);
        container.add(buttonHeadman);

        buttonStudent.addActionListener(new ButtonStudentEvent());
        buttonTeacher.addActionListener(new ButtonTeacherEvent());
        buttonUniversity.addActionListener(new ButtonUniversityEvent());
        buttonHeadman.addActionListener(new ButtonHeadmanEvent());

        return frame;
    }

    class ButtonStudentEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            StudentGUI studentGUI = new StudentGUI(university);
            studentGUI.setVisible(true);
        }
    }

    class ButtonTeacherEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            TeacherGUI teacherGUI = new TeacherGUI(university);
            JFrame jFrame = teacherGUI.buildTeacherGUIFrame();
            jFrame.setVisible(true);
        }
    }

    class ButtonUniversityEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            UniversityGUI universityGUI = new UniversityGUI(university);
            universityGUI.setVisible(true);
        }
    }

    class ButtonHeadmanEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            HeadmanGUI headmanGUI = new HeadmanGUI(university);
            headmanGUI.setVisible(true);
        }
    }
}