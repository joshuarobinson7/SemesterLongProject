/*
Josh Robinson
CS 1410-1
Semester Project
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial") //prevents the serial warning

public class Map extends JPanel{
	
	private BufferedImage tower;
	private Tower t1;
	private BackGround bg;
	private Bad [] b1;
	private Bad guy;
	private BufferedImage troll;
	private Bullet1 bull;
	private BufferedImage course;
	private boolean check;
	private Tower [] towers;
	private Tower t2;
	private int money;
	private Bullet1 [] array;	
	
	public Map() {
		try {
			tower = ImageIO.read(new File("Tower.png"));
			troll = ImageIO.read(new File("Troll.png"));
			course = ImageIO.read(new File("Tower.png"));
		}
		catch (IOException e) {
			System.out.println("Unable to read in image file");
		}
		//initializes arrays and creates the objects
		bg = new BackGround();
		t1 = new Tower(70, 300, course, 25, 25);
		b1 = new Bad [10];
		for(int x = 0; x < 10; x++) 
			b1[x]= null;
		
		check = false;
		
		towers = new Tower [4];
		for(int z = 0; z< towers.length; z++) {
			towers[z]=null;
		}
		guy = null;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		bg.paint(g);
		t1.drawImage(g);
		
		//draw bad guys
		for(int x = 0; x< 10; x++) {
			if(b1[x] != null) {
					b1[x].drawImage(g);	
		}
		}
		//check to see if bullets were created
		if(check == true)
		{
			t1.bullet(g);
			for(int x = 0; x < towers.length; x++) {
				if(towers[x] != null)
					towers[x].bullet(g);
			}
			//kills the enemy
			for(int z = 0; z < b1.length; z++) {
				if((b1[z]!=null) && (t1.hit(b1[z].getX(), b1[z].getY()))== true) {
					b1[z]=null;
					money+=10;
					
				}
			}
			//if all enemies are dead then stop printing bullets
			if(b1[0]==null && b1[1]==null && b1[2]==null && b1[3]==null && b1[4]==null && b1[5]==null && b1[6]==null && b1[7]==null && b1[8]==null && b1[9]==null) {
				check=false;
			}
				
		}
		//draw extra towers
		for(int x = 0; x < towers.length; x++) {
			if(towers[x] != null)
				towers[x].drawImage(g);
		}
		
		try {Thread.sleep(50);} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void fire() {
		int pos = 0;
		int d =0;
		check = true;
		//create the bullets using towers createBullets method
		t1.createBullets();
		//creates bullets at each tower
		for(int x = 0; x < towers.length; x++) {
			if(towers[x] != null)
				towers[x].createBullets();
		}
		//initializes bad guys
		guy = new Bad(0,265,troll,20,20,0,0);
		for(int x = 0; x<10;x++) {
			if(b1[x]==null) {
				if(pos > 0) {
					b1[x-1].getX();
					d=d-25;
					guy = new Bad(d,265,troll,20,20,0,0);
				}
				
				b1[x]= guy;
				
				pos++;
			}
		}
		
	}
	
	public void createTower() {
		//if your money is 100 after killing 10 guys you can buy a tower
		System.out.println("Your money equals: " +money);
		t2 = new Tower(70, 300, course, 25, 25);
		if(money >= 100) {
			money-=100;
			System.out.println("Your money equals: " +money);
		for(int z =0; z<towers.length;z++) {
			if(towers[z] == null) {
				if(z== 0)
				t2 = new Tower(170, 350, course, 25, 25);
				else if(z ==1)
					t2 = new Tower(300, 350, course, 25, 25);
				else if(z ==2)
					t2 = new Tower(350, 240, course, 25, 25);
				else if(z ==3)
					t2 = new Tower(170, 350, course, 25, 25);
				towers[z]=t2;
				z=5;
			}
				
		}
		}
	}
}

//BackGround
@SuppressWarnings("serial")
class BackGround extends JPanel{
	private BufferedImage course;
	private StationaryObject b = null;
	
	public BackGround() {
		try {
			course = ImageIO.read(new File("Map.png"));
			//b = new StationaryObject(0,0, course, 299, 222);
			b = new StationaryObject(0,0, course, 500, 500);
		}
		catch (IOException e) {
			System.out.println("Unable to read in image file");
		}
	}
	public void paint(Graphics g){
		if(b != null)b.drawImage(g);
		}
}

/*//Tower
@SuppressWarnings("serial")
class Turret extends JPanel{
	private BufferedImage course;
	private Tower b = null;
	
	public Turret() {
		try {
			course = ImageIO.read(new File("Tower.png"));
			b = new Tower(70, 300, course, 25, 25);
		}
		catch (IOException e) {
			System.out.println("Unable to read in image file");
		}
	}
	public void paint(Graphics g){
		if(b != null)b.drawImage(g);
		}
}*/