package de.rbs90.colorAimBot;

import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.TimerTask;

import org.w3c.dom.css.Rect;

public class ScreencheckerTask extends TimerTask{

	
	@Override
	public void run() {
		BufferedImage img = Main.r.createScreenCapture(Main.rect);
		for (int x = 0; x < Main.rect.width; x++)
			for (int y = 0; y < Main.rect.height; y++)
				if (img.getRGB(x, y) == Main.targetCol)
				{
					//Point old_loc = MouseInfo.getPointerInfo().getLocation();
					Main.r.mouseMove(Main.rect.x + x, Main.rect.y + y);
					Main.r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					
					//System.out.println("Mouse pressed...");
					break;
				}
	}

}
