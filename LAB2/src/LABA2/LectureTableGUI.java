package LABA2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class LectureTableGUI extends JFrame{
    private ArrayList<Lecture> listExercise = new ArrayList<Lecture>();

    public LectureTableGUI(University university){
        super("Table of exercises");//в класс JFrame передаём название нашего окна
        this.setBounds(650, 250, 425, 175);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Object[] col = new String[]{"Date","Topic"};
        DefaultTableModel tableModel = new DefaultTableModel(0,2);
        JTable table = new JTable(tableModel);

        listExercise = university.getLecture();

        tableModel.setColumnIdentifiers(col);

        if (tableModel.getRowCount() == 0) {

            for (int i = 0; i < listExercise.size(); i++) {
                Object[] obj = {listExercise.get(i).getDate(), listExercise.get(i).getTopic()};
                tableModel.addRow(obj);
            }
        }

        Container tableOfTeacher = this.getContentPane();
        tableOfTeacher.add(table);
    }
}
