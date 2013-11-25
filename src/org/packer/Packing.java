package org.packer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;



public class Packing {

	public static void packRectangles(List<Rectangle> rectangles, Algorithm algorithm, int maxWidth){
		Packer packer;
		switch(algorithm){
			case FIRST_FIT_DECREASING_HEIGHT:
				packer = new PackerFFDH(maxWidth);
				packer.pack(rectangles);
				break;
			case NEXT_FIT_DECREASING_HEIGHT:
				packer = new PackerNFDH(maxWidth);
				packer.pack(rectangles);
				break;
		}
	}
	
	public enum Algorithm{
		FIRST_FIT_DECREASING_HEIGHT,
		NEXT_FIT_DECREASING_HEIGHT
	}
}
