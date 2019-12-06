import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
Josh Robinson
1410-1
Semester Project
*/

public class Bad extends MovingObject{
	private int vx;
	private int vy;
	private int x;
	private int y;
	
	public Bad(int x, int y, BufferedImage bi, int wide, int high, int vx, int vy){
		super(x,y,bi,wide,high,vx,vy);
		this.bi=bi;
		this.vx=vx;
		this.vy=vy;
		this.x=x;
		this.y=y;
	}
	
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,x+vx,y+vy, wide, high, null);
		
		if(vy == 0 && x <= 70 )
			x+=5;
		if(x==75 && (y<=265 && y > 110)) {
			y-=5;	
		}
		if(y == 110 && (x>=75 && x < 170))
			x+=5;
		if(x == 170 && (y >= 110 && y < 310))
			y+=5;
		if(y==310 && (x>=170 && x< 305))
			x+=5;
		if(x==305 && (y<= 310 && y> 215))
			y-=5;
		if(y == 215 && (x>= 305 && x <500)) {
			x+=5;
			//Lose a life
		}
		
	}
	
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}

}