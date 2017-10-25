package tests;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import de.sciss.packing2d.Packer;

public class PackerBFDHTest {
    private Packer packer;
	private Rectangle r1, r2, r3;

    public PackerBFDHTest(){
		List<Rectangle> rectangles = new ArrayList<>();
        r1 = new Rectangle(10, 12);
        r2 = new Rectangle(12, 10);
        r3 = new Rectangle(4, 3);
        rectangles.add(r1);
        rectangles.add(r2);
        rectangles.add(r3);
    }

    @Before
    public void setUp() throws Exception {
        //this.packer = new PackerBFDH(20, false);
    }

    @Test
    public void correctBestFit() {
        //this.packer.pack(rectangles);
        assertEquals(0, r1.x);
        assertEquals(0, r1.y);
        assertEquals(0, r2.x);
        assertEquals(12, r2.y);
        assertEquals(12, r3.x);
        assertEquals(12, r3.y);
    }

}
