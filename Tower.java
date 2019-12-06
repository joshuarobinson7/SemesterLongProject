/*
Josh Robinson
CS 1410-1
Semester Project
*/
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class Tower extends StationaryObject{	
	private Bullet1 [] array;
	private Bullet1 b1 = null;
	private int posx;
	public Tower(int x, int y, BufferedImage bi, int wide, int high){
		super(x,y,bi,wide,high);
	}//end of constructor
	
	//create bullets in the array
	public void createBullets() {
		array = new Bullet1 [10];
		for(int z= 0; z < 10; z++ ) {
			array[z]= new Bullet1(x+5,y,4,4);
		}
		
	}
	
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,x, y,wide,high,null);	
				
	}
	
	public void bullet(Graphics g) {
		//add next bullet
		for(int z = 0; z < array.length; z++) {
			if(array[z] != null) {
				if(z == 0) {
					array[z].drawImage(g);
				}
				else if(array[z-1] == null) {
					array[z].drawImage(g);
				}
				else if(array[z-1].getY() <= (y-40)) {
					array[z].drawImage(g);
				}
			}
		
		}	
		//check to see if bullet is offmap
		for(int x=0; x<array.length;x++) {
			if((array[x]!= null) && (array[x].getY() <= 0))
				array[x]=null;
		}
	}
	
	//check to see if bullet position is in Bad
	public boolean hit(int badX, int badY){
		boolean z = false;
		for(int o =0; o<array.length; o++) {
			if((array[o] != null) && (badX >= array[o].getX() && badX <= array[o].getX()+20)) {
				//z=true;
				if((array[o].getY()<= badY+20) && (array[o].getY()>=badY)) {
					z=true;
				}
						
			}
		}
			return z;
	}
	
	
	
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	
	public void kill() {
		b1 = null;
	}
	
}