//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(20,20,50,50,3);
	}

	public Alien(int x, int y)
	{
		this(x,y,50,50,3);
	}

	public Alien(int x, int y, int s)
	{
		this(x,y,50,50,s);
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		setSpeed(s);
		try
		{
			URL url = getClass().getResource("alien.JPG");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Scans reveal no alien life.");
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

   public void move(String direction)
	{
	   if(getX()<0||getX()>800) {
		   setY(getY()+80);
		   setSpeed(-getSpeed());
		   if(getX()<400) {
			   setX(0);
		   }
		   else {
			   setX(800);
		   }
	   }
	   else {
		   setX(getX()+speed);
	   }
	}
   	public void move(int width, int height)
	{
	   if(getX()<0||getX()>width) {
		   setY(getY()+80);
		   setSpeed(-getSpeed());
		   if(getX()<width/2) {
			   setX(0);
		   }
		   else {
			   setX(width);
		   }
	   }
	   else {
		   setX(getX()+speed);
	   }
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() +" "+ getSpeed();
	}
}
