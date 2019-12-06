//stationary object to add to our window
/*
 * Josh Robinson
 * CS 1410
 * FireBall2*/

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class StationaryObject
{
	protected int x; 
	protected int y;
	protected BufferedImage bi; 
	protected int wide;
	protected int high;

	StationaryObject(int x, int y, BufferedImage bi, int wide, int high)
	{
		this.x = x;
		this.y = y; 
		this.bi= bi;
		this.wide = wide; 
		this.high = high;
	}
	
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,x, y,wide,high,null);
	}

	
}