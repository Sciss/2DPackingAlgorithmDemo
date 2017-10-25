package demo;

import java.awt.Rectangle;

public class IndexedRectangle extends Rectangle {
	private int index;
	public IndexedRectangle(int width, int height){
		super(width, height);
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
