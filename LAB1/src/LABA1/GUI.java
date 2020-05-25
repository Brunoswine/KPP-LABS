package LABA1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton buttonCopyFromOneToSecond = new JButton("Копировать 1 в 2");
    private JButton buttonCopeFromSecondToThird = new JButton("Копировать 2 в 3");
    private JTextField inputFirstString = new JTextField("",5);
    private JLabel labelFirstString = new JLabel("                 1");
    private JTextField inputSecondString = new JTextField("",5);
    private JLabel labelSecondString = new JLabel("                 2");
    private JTextField inputThirdString = new JTextField("",5);
    private JLabel labelThirdString = new JLabel("                 3");


    public GUI () {
        super("First lab");//в класс JFrame передаём название нашего окна
        this.setBounds(650,250,425,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();//содержит все поля
        container.setLayout(new GridLayout(3,3,3,3));
        container.add(labelFirstString);
        container.add(labelSecondString);
        container.add(labelThirdString);
        container.add(inputFirstString);
        container.add(inputSecondString);
        container.add(inputThirdString);
        container.add(buttonCopyFromOneToSecond);
        container.add(buttonCopeFromSecondToThird);

        buttonCopyFromOneToSecond.addActionListener(new ButtonCopyFromOneToSecondEvent());
        buttonCopeFromSecondToThird.addActionListener(new ButtonCopyFromSecondToThirdEvent());
    }

    class ButtonCopyFromOneToSecondEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String mess1 = inputFirstString.getText();
            inputSecondString.setText(mess1);
        }
    }
    class ButtonCopyFromSecondToThirdEvent implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String mess1 = inputSecondString.getText();
            inputThirdString.setText(mess1);
        }
    }

}

