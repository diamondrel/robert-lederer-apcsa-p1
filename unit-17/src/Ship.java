//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.geom.Line2D;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private long tricobalt = 0;

	public Ship()
	{
		this(10,450,80,80,2);
	}

	public Ship(int x, int y)
	{
		this(x, y, 10, 10,5);
	}

	public Ship(int x, int y, int s)
	{
		this(x, y, 10, 10,s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		setSpeed(s);
		try
		{
			URL url = getClass().getResource("ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Internal scanners offline.");
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
		if (direction=="L") {
			setX(getX()-(getSpeed()/2));
		}
		if (direction=="R") {
			setX(getX()+(getSpeed()/2));
		}
		if (direction=="N") {
			setY(getY()-(getSpeed()/2));
		}
		if (direction=="S") {
			setY(getY()+(getSpeed()/2));
		}
	}
	
	public void fire(String weapon) {
		if (weapon=="photonTorpedosSpread") {
			if (System.currentTimeMillis()-tricobalt>=10000) {
				tricobalt = System.currentTimeMillis();
				for(Double i:traceGroup(5)) {
					
				}
			}
		}
	}
	public Double[] traceGroup(int tracers) {
		Double[] result = new Double[tracers];
		for (int i = 0; i<tracers;i++) {
			result[i]=trace();
		}
		return result;
	}
	public Double trace() {
		Double result = 566.6845825796453;
		Double finalX=Math.atan2(result - getX(),getY());
		System.out.println(result-getX()+" | Random:" +result);
		System.out.println("Sin: "+3*Math.sin(finalX)+" | Cos: "+3*Math.cos(finalX));
		return finalX;
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
