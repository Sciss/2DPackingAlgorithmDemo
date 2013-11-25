package demo;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.packer.Packing.Algorithm;

class PackingSettingsPanel extends JPanel {
	private JComboBox<Algorithm> algorithmChooser;
	private Algorithm[] algorithms = {Algorithm.FIRST_FIT_DECREASING_HEIGHT, Algorithm.NEXT_FIT_DECREASING_HEIGHT};
	public PackingSettingsPanel(){
		Border border = BorderFactory.createEmptyBorder(5, 0, 5, 0);
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JLabel lbl = new JLabel("Packing Algorithm");
		lbl.setAlignmentX(CENTER_ALIGNMENT);
		this.algorithmChooser = new JComboBox<Algorithm>(algorithms);
		this.add(lbl);
		this.add(algorithmChooser);
	}
	
	public Algorithm getSelectedAlgorithm(){
		return (Algorithm)this.algorithmChooser.getSelectedItem();
	}
}
