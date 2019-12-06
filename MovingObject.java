//stationary object to add to our window
/*
 * Josh Robinson
 * CS 1410
 * FireBall2*/

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public abstract class MovingObject extends StationaryObject
{
//Create instants variables to hold the needed velocities
	private int vx;
	private int vy;

	public MovingObject(int x, int y, BufferedImage bi, int wide, int high, int vx, int vy)
	{
		//call the super constructor and then set the velocities
		super(x, y, bi, wide, high);
		//posx = 0;
		//posy = 0;
		vx = 0;
		vy = 0;
	}
	
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
		
	//renders our object to the screen
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,x+vx,y+vy, wide, high, null);
	}
	

	
}