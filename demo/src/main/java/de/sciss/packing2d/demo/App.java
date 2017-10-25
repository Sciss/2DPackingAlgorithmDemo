package de.sciss.packing2d.demo;

import java.awt.*;

import javax.swing.*;

class App {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
