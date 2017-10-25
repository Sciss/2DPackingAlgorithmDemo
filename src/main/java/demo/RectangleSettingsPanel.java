package demo;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

class RectangleSettingsPanel extends JPanel {
	private JTextField fieldMinWidth;
	private JTextField fieldMaxWidth;
	private JTextField fieldMinHeight;
	private JTextField fieldMaxHeight;
	private static final int MIN_RECT_WIDTH = 16;
	private static final int MAX_RECT_WIDTH = 256;
	private static final int MIN_RECT_HEIGHT = 16;
	private static final int MAX_RECT_HEIGHT = 256;
	
	public RectangleSettingsPanel(){
		Border border = BorderFactory.createEmptyBorder(0, 0, 5, 0);
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JLabel lbl = new JLabel("Rectangle settings");
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		this.add(lbl);
		this.addFields();
	}
	
	public int getMinWidth(){
		String minWidthInput = this.fieldMinWidth.getText();
		if (!minWidthInput.isEmpty()){
			try {
				int minWidth = Integer.parseInt(minWidthInput);		
				int width = Math.min(Math.max(minWidth, MIN_RECT_WIDTH), MAX_RECT_WIDTH);
				this.fieldMinWidth.setText(width + "");
				return width;
			} catch (Exception ex) {	
				this.fieldMinWidth.setText(MIN_RECT_WIDTH + "");
			}
		}
		return MIN_RECT_WIDTH;
	}
	
	public int getMaxWidth(){
		String maxWidthInput = this.fieldMaxWidth.getText();
		if (!maxWidthInput.isEmpty()){
			try {
				int maxWidth = Integer.parseInt(maxWidthInput);	
				int width = Math.max(Math.min(maxWidth, MAX_RECT_WIDTH), MIN_RECT_WIDTH);
				this.fieldMaxWidth.setText(width + "");
				return width;
			} catch (Exception ex) {
				this.fieldMaxWidth.setText(MAX_RECT_WIDTH + "");
			}
		}
		return MAX_RECT_WIDTH;
	}
	public int getMinHeight(){
		String minHeightInput = this.fieldMinHeight.getText();
		if (!minHeightInput.isEmpty()){
			try {
				int minHeight = Integer.parseInt(minHeightInput);		
				int height = Math.min(Math.max(minHeight, MIN_RECT_HEIGHT), MAX_RECT_HEIGHT);
				this.fieldMinHeight.setText(height + "");
				return height;
			} catch (Exception ex) {	
				this.fieldMinHeight.setText(MIN_RECT_HEIGHT + "");
			}
		}
		return MIN_RECT_HEIGHT;
	}
	
	public int getMaxHeight(){
		String maxHeigthInput = this.fieldMaxHeight.getText();
		if (!maxHeigthInput.isEmpty()){
			try {
				int maxHeight = Integer.parseInt(maxHeigthInput);	
				int height = Math.max(Math.min(maxHeight, MAX_RECT_HEIGHT), MIN_RECT_HEIGHT);
				this.fieldMaxHeight.setText(height + "");
				return height;
			} catch (Exception ex) {
				this.fieldMaxHeight.setText(MAX_RECT_HEIGHT + "");
			}
		}
		return MAX_RECT_HEIGHT;
	}
	
	private void addFields(){
		this.fieldMinWidth = new JTextField(4);
		this.fieldMinWidth.setText(MIN_RECT_WIDTH + "");
		this.fieldMaxWidth = new JTextField(4);
		this.fieldMaxWidth.setText(MAX_RECT_WIDTH + "");
		JPanel widthSettings = new JPanel(new FlowLayout());
		widthSettings.add(new JLabel("Min Width:"));
		widthSettings.add(this.fieldMinWidth);
		widthSettings.add(new JLabel("Max Width:"));	
		widthSettings.add(this.fieldMaxWidth);
		this.add(widthSettings);
		
		this.fieldMinHeight = new JTextField(4);
		this.fieldMinHeight.setText(MIN_RECT_HEIGHT + "");
		this.fieldMaxHeight = new JTextField(4);
		this.fieldMaxHeight.setText(MAX_RECT_HEIGHT + "");
		JPanel heigthSettings = new JPanel(new FlowLayout());
		heigthSettings.add(new JLabel("Min Height:"));
		heigthSettings.add(this.fieldMinHeight);
		heigthSettings.add(new JLabel("Max Height:"));	
		heigthSettings.add(this.fieldMaxHeight);
		this.add(heigthSettings);
	}
}
