package LABA2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TeacherTableGUI extends JFrame {
    private ArrayList<Teacher> listOfTeachers = new ArrayList<Teacher>();

    public TeacherTableGUI(University university){
        super("Table of teachers");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 175);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Object[] col = new String[]{"Name","Surname"};
        DefaultTableModel tableModel = new DefaultTableModel(0,2);
        JTable table = new JTable(tableModel);
        listOfTeachers = university.getTeachers();

        tableModel.setColumnIdentifiers(col);

        if (tableModel.getRowCount() == 0) {

            for (int i = 0; i < listOfTeachers.size(); i++) {
                Object[] obj = {listOfTeachers.get(i).getName(), listOfTeachers.get(i).getSurname()};
                tableModel.addRow(obj);
            }
        }

        Container tableOfTeacher = this.getContentPane();
        tableOfTeacher.add(table);
    }
}
