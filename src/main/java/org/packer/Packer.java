package org.packer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Packer<T extends Rectangle>{
	protected int stripWidth;
	protected List<T> rectangles;
	public Packer(int stripWidth, List<T> rectangles){
		this.stripWidth = stripWidth;
		this.rectangles = this.copyRectangles(rectangles);
	}
	
	public static <U extends Rectangle> List<U> pack(List<U> rectangles, Algorithm algorithm, int stripWidth){
		Packer<U> packer;
		switch(algorithm){
		case FIRST_FIT_DECREASING_HEIGHT:
			packer = new PackerFFDH<U>(stripWidth, rectangles);
			return packer.pack();
		case NEXT_FIT_DECREASING_HEIGHT:
			packer = new PackerNFDH<U>(stripWidth, rectangles);
			return packer.pack();
		case BEST_FIT_DECREASING_HEIGHT:
			packer = new PackerBFDH<U>(stripWidth, rectangles);
			return packer.pack();
		default:
			return new ArrayList<U>();
		}
	}
	
	public abstract List<T> pack();
	
	protected void sortByNonIncreasingHeight(List<T> rectangles){
		Collections.sort(rectangles, new NonIncreasingHeightRectangleComparator());
	}
	protected void sortByNonIncreasingWidth(List<T> rectangles){
		Collections.sort(rectangles, new NonIncreasingWidthRectangleComparator());
	}
	
	private List<T> copyRectangles(List<T> rectangles){
		List<T> copy = new ArrayList<T>();
		for (T r : rectangles){
			copy.add((T)r.clone());
		}
		return copy;
	}
	
	private class NonIncreasingHeightRectangleComparator implements Comparator<Rectangle>{
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return Integer.compare(o2.height, o1.height);
		}		
	}
	private class NonIncreasingWidthRectangleComparator implements Comparator<Rectangle>{
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return Integer.compare(o2.width, o1.width);
		}		
	}
	
	public enum Algorithm{
		FIRST_FIT_DECREASING_HEIGHT,
		NEXT_FIT_DECREASING_HEIGHT,
		BEST_FIT_DECREASING_HEIGHT
	}
	
	public static Algorithm[] getAllAlgorithms(){
		Algorithm[] algorithms = {Algorithm.FIRST_FIT_DECREASING_HEIGHT,
				Algorithm.NEXT_FIT_DECREASING_HEIGHT,
				Algorithm.BEST_FIT_DECREASING_HEIGHT};
		return algorithms;
	}
}
