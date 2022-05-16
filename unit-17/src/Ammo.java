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
	private int speed;
	private Image image;
	private Line2D trajectory;
	private Double finalX;

	public Ammo()
	{
		this(0,0,0,null);
	}

	public Ammo(int x, int y)
	{
		this(x,y,2,null);
	}
	public Ammo(int x, int y, int s) {
		this (x,y,s,null);
	}

	public Ammo(int x, int y, int s,Double trace)
	{
		super(x,y,5,5);
		setSpeed(s);
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

	public void setSpeed(int s)
	{
	   speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	
	public void move( String direction )
	{
		while(getX()>0) {
			
		}
	}

	public String toString()
	{
		return super.toString()+", "+getSpeed();
	}
}
