package demo;

import java.awt.Rectangle;
import java.util.Comparator;

class NonIncreasingHeightRectangleComparator implements Comparator<Rectangle> {
	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {
		return Integer.compare(arg1.height, arg0.height);
	}
}
