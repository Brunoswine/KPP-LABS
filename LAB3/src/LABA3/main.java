package LABA3;

import javax.swing.*;

public class main {
    public static void main(String[] args){

        GUI app = new GUI();
        JFrame jFrame = app.buildGUIFrame();
        jFrame.setVisible(true);
    }
}
