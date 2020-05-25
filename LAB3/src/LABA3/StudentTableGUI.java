package LABA3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentTableGUI extends JFrame {
    private ArrayList<AbstractStudent> listOfStudent = new ArrayList<AbstractStudent>();

    public StudentTableGUI(University university){
        super("Table of students");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 175);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Object[] col = new String[]{"Name","Surname","Marks"};
        DefaultTableModel tableModel = new DefaultTableModel(0,3);
        JTable table = new JTable(tableModel);
        listOfStudent = university.getStudents();

        tableModel.setColumnIdentifiers(col);

        if (tableModel.getRowCount() == 0) {

            for (int i = 0; i < listOfStudent.size(); i++) {
                Object[] obj = {listOfStudent.get(i).getName(), listOfStudent.get(i).getSurname(),listOfStudent.get(i).getMarks()};
                tableModel.addRow(obj);
            }
        }

        Container tableOfTeacher = this.getContentPane();
        tableOfTeacher.add(table);
    }
}
