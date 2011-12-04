package de.rbs90.colorAimBot;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;


public class Main {

	/**
	 * @param args
	 */

	static Point left;
	static Point right;
	static int clickcount;
	static Rectangle rect;
	
	static Timer timer;
	static int targetCol;
	
	static Robot r;
	
	public static void main(String[] args) throws AWTException, IOException {
		clickcount = 0;
		r = new Robot();
		timer = new Timer();
		System.out.println("Place mouse on left up corner and press ENTER...");
		System.in.read();
		left = MouseInfo.getPointerInfo().getLocation();
		System.out.println("now move on right down corner and press Enter...");
		
		System.in.read();
		right = MouseInfo.getPointerInfo().getLocation();
		rect = new Rectangle(left, getDimensionFromPoints(left, right));
		System.out.println("now move on the color to click on and press enter..."); 
		
		System.in.read();
		BufferedImage img = r.createScreenCapture(rect);
		Point e = MouseInfo.getPointerInfo().getLocation();
		
		targetCol = img.getRGB((int) e.getX() - left.x, (int) e.getY() - left.y);
		System.out.println("OK...starting in 5 sec;)");
		timer.schedule(new ScreencheckerTask(), 5000, 20);

	}
	
	private static Dimension getDimensionFromPoints(Point p1, Point p2)
	{
		return new Dimension((int) Math.abs(p1.getX() - p2.getX()), (int) Math.abs(p1.getY() - p2.getY()));
	}

}
