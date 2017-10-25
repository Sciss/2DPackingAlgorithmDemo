package de.sciss.packing2d.demo;

import de.sciss.packing2d.Packer;
import de.sciss.packing2d.Packer.Algorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SettingsPanel extends JPanel {
    private RectangleSettingsPanel settingsPanel;
    private DrawCanvas canvas;
    private PackingSettingsPanel packingSettingsPanel;
    private final int BIN_WIDTH = 512;
    private final int BIN_HEIGHT = 512;

    private List<IndexedRectangle> generatedRectangles;

    public SettingsPanel(DrawCanvas canvas){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.addComponents();
        this.canvas = canvas;
    }

    private void addComponents(){
        this.settingsPanel = new RectangleSettingsPanel();
        this.settingsPanel.setAlignmentY(TOP_ALIGNMENT);
        this.add(this.settingsPanel);

        JButton btnGenerateRectangles = new JButton("Generate rectangles");
        btnGenerateRectangles.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGenerateRectangles.addActionListener(new GenerateRectanglesListener());
        this.add(btnGenerateRectangles);

        this.packingSettingsPanel = new PackingSettingsPanel();
        this.add(packingSettingsPanel);

        JButton btnPackRectangles = new JButton("Pack Rectangles");
        btnPackRectangles.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPackRectangles.addActionListener(new PackRectanglesListener());
        this.add(btnPackRectangles);
    }

    private class GenerateRectanglesListener implements ActionListener{

        private int maxArea = BIN_WIDTH * BIN_HEIGHT / 2;
        private Random rnd = new Random();
        @Override
        public void actionPerformed(ActionEvent arg0) {

             int maxWidth = settingsPanel.getMaxWidth();
             int minWidth = settingsPanel.getMinWidth();
             int maxHeight = settingsPanel.getMaxHeight();
             int minHeight = settingsPanel.getMinHeight();
            List<IndexedRectangle> randomRectangles = new ArrayList<>();

            int accumulatedArea = 0;
            while(true){
                int width = rnd.nextInt(maxWidth-minWidth+1) + minWidth;
                int height = rnd.nextInt(maxHeight-minHeight+1) + minHeight;
                int area = width * height;
                if (area + accumulatedArea <= maxArea){
                    IndexedRectangle r = new IndexedRectangle(width, height);
                    randomRectangles.add(r);
                    accumulatedArea += area;
                }else{
                    if (maxWidth > minWidth){
                        maxWidth = Math.max(minWidth, maxWidth / 2);
                        maxHeight = Math.max(minHeight, maxHeight / 2);
                    }
                    else break;
                }
            }
            generatedRectangles = randomRectangles;
            generatedRectangles.sort(new NonIncreasingHeightRectangleComparator());
            for (int i = 1; i <= generatedRectangles.size(); i++){
                generatedRectangles.get(i-1).setIndex(i);
            }
            canvas.setRectangles(randomRectangles);
        }

    }

    private class PackRectanglesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (generatedRectangles != null && !generatedRectangles.isEmpty()){
                Algorithm selectedAlgorithm = packingSettingsPanel.getSelectedAlgorithm();
                List<IndexedRectangle> rectangles = Packer.pack(generatedRectangles, selectedAlgorithm, BIN_WIDTH);
                canvas.setRectangles(rectangles);
                canvas.repaint();
            }
        }
    }
}
