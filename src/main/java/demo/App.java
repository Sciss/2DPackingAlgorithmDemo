package demo;

import java.awt.*;

import javax.swing.*;

class App {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
