//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private Image image;
	private int speed;
	private int xSpeed;
	private int ySpeed;

	public Ammo()
	{
		this(0,0,0,2);
	}
	public Ammo(int x, int y)
	{
		this(x,y,0,2);
	}

	public Ammo(int x, int y,int xs, int ys)
	{
		super(x,y,(int)(8+Math.random()*8),(int)(8+Math.random()*8));
		setSpeed(xs,ys);
		setSpeed(xs+ys);
		try
		{
			URL url = getClass().getResource("photonTorpedo.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Torpedo tubes inoperational.");
		}
	}
	
	public void setSpeed(int s) {
		speed =s;
	}
	
	public void setSpeed(int xs,int ys)
	{
	   setXSpeed(xs);
	   setYSpeed(ys);
	}
	
	public void setXSpeed(int xs) {
		xSpeed=xs;
	}
	
	public void setYSpeed(int ys) {
		ySpeed=ys;
	}
	
	public int getSpeed() {
		return speed;
	}

	public int getXSpeed()
	{
	   return xSpeed;
	}
	public int getYSpeed()
	{
	   return ySpeed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	
	public void move(String direction)
	{
			setY(getY()-ySpeed);
			setX(getX()+xSpeed);
	}

	public String toString()
	{
		return super.toString()+", "+getSpeed()+", "+getXSpeed()+", "+getYSpeed();
	}
}
