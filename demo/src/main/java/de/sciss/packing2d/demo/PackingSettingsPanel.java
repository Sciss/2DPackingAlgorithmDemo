package de.sciss.packing2d.demo;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import de.sciss.packing2d.Packer;
import de.sciss.packing2d.Packer.Algorithm;

class PackingSettingsPanel extends JPanel {
    private JComboBox<Algorithm> algorithmChooser;

	public PackingSettingsPanel(){
        Border border = BorderFactory.createEmptyBorder(5, 0, 5, 0);
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel lbl = new JLabel("Packing Algorithm");
        lbl.setAlignmentX(CENTER_ALIGNMENT);
		Algorithm[] algorithms = Packer.getAllAlgorithms();
		this.algorithmChooser = new JComboBox<>(algorithms);
        this.add(lbl);
        this.add(algorithmChooser);
    }

    public Algorithm getSelectedAlgorithm(){
        return (Algorithm)this.algorithmChooser.getSelectedItem();
    }
}
