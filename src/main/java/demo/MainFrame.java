package demo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

class MainFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	
	public MainFrame(){		
		setup();
		addComponents();
	}
	
	private void setup(){
		//setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Demo");
		setResizable(false);
		setLocationToMiddle();
		setLayout(new FlowLayout());
	}
	
	private void addComponents(){
		DrawCanvas canvas = new DrawCanvas();
		SettingsPanel tools = new SettingsPanel(canvas);
		this.getContentPane().add(canvas);
		this.getContentPane().add(tools);
		this.pack();
	}
	
	private void setLocationToMiddle(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int locationX = screenSize.width / 2 - DEFAULT_WIDTH / 2;	
		int locationY = screenSize.height / 2 - DEFAULT_HEIGHT / 2;	
		setLocation(locationX, locationY);
	}
}
