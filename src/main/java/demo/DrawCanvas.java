package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

class DrawCanvas extends JPanel{
	private Canvas canvas;
	
	public DrawCanvas(){
		this.canvas = new Canvas();
		this.add(canvas);
		this.setBackground(Color.white);
		Border border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
	}
	
	public void addRectangle(IndexedRectangle r){
		this.canvas.addRectangle(r);
	}
	public void clearRectangles(){
		this.canvas.clearRectangles();
	}
	public void setRectangles(List<IndexedRectangle> rectangles){
		this.canvas.setRectangles(rectangles);
		this.canvas.repaint();
	}
	
	private class Canvas extends JComponent{
		List<IndexedRectangle> rectangles;
		public Canvas(){
			this.rectangles = new ArrayList<IndexedRectangle>();
		}
		
		public void addRectangle(IndexedRectangle r){
			this.rectangles.add(r);
		}
		public void setRectangles(List<IndexedRectangle> rectangles){
			this.rectangles = rectangles;
		}
		public void clearRectangles(){
			this.rectangles.clear();
		}
		
		public void paintComponent(Graphics g){
			g.setColor(Color.blue);
			for (IndexedRectangle r : this.rectangles){
				int midX = r.x + r.width/2-5;
				int midY = r.y + r.height / 2+5;
				g.drawRect(r.x, r.y, r.width, r.height);
				g.drawString(r.getIndex()+ "", midX, midY);
			}
		}
		
		public Dimension getPreferredSize(){
			return new Dimension(513, 513);
		}
	}
}


