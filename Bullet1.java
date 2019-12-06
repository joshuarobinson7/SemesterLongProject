//stationary object to add to our window
/*
 * Josh Robinson
 * CS 1410
 * FireBall2*/

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class Bullet1 
{
	private int vx;
	private int vy;
	private int x;
	private int y;

	public Bullet1(int x, int y, int vx, int vy)
	{
		this.x = x;
		this.y = y;
		this.vx=vx;
		this.vy=vy;
	}
	
	public void drawImage(Graphics g)
	{
		g.setColor(Color.BLACK);
		y-=vy;
		g.fillOval(x, y, 10,10);
	}
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	

	
}