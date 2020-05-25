package LABA3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemplateAddGUI extends JFrame {
    private JButton buttonAdd;
    private JButton buttonViewTable;
    private JLabel label1;
    private JLabel label2;
    private JTextField getInput1 = new JTextField();
    private JTextField getInput2 = new JTextField();
    private String action = new String();
    private University university;

    public TemplateAddGUI(String title,String infoButton1,String infoButton2,String label1,String label2,String typeOfAdd,University university){

        super(title);//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 150);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.buttonAdd = new JButton(infoButton1);
        this.buttonViewTable = new JButton(infoButton2);
        this.label1 = new JLabel(label1);
        this.label2 = new JLabel(label2);
        this.action = typeOfAdd;
        this.university = university;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,5,5));
        panel.add(this.label1);
        panel.add(this.getInput1);
        panel.add(this.label2);
        panel.add(this.getInput2);

        Container containerTeacher = this.getContentPane();//содержит все поля
        containerTeacher.setLayout(new BoxLayout(containerTeacher,BoxLayout.Y_AXIS));
        containerTeacher.add(panel);
        containerTeacher.add(buttonAdd);
        containerTeacher.add(buttonViewTable);

        buttonAdd.addActionListener(new ButtonAdd());
        buttonViewTable.addActionListener(new ButtonView());
    }

    class ButtonAdd implements ActionListener {
        public void actionPerformed (ActionEvent e){
            if(action == "addNewTeacher")
                university.setTeachers(new Teacher(getInput1.getText(),getInput2.getText()));
            else if (action == "addNewLecture")
                university.setLecture(new Lecture(getInput1.getText(),getInput2.getText()));
            else if (action == "addNewStudent")
                university.setStudents(new Student(getInput1.getText(),getInput2.getText(),"0"));
        }
    }

    class ButtonView implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(action == "addNewTeacher") {
                TeacherTableGUI app = new TeacherTableGUI(university);
                app.setVisible(true);
            }
            else if(action == "addNewLecture"){
                LectureTableGUI app = new LectureTableGUI(university);
                app.setVisible(true);
            }
            else if (action == "addNewStudent"){
                StudentTableGUI app = new StudentTableGUI(university);
                app.setVisible(true);
            }
        }
    }

}
