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
	private int torpS;
	private Image image;
	private long tricobalt=0;
	private long massTricobalt = 0;
	private long phaserClock=0;
	private long emitter=0;
	

	public Ship()
	{
		this(10,450,80,80,2,6);
	}

	public Ship(int x, int y)
	{
		this(x, y, 80, 80,2,6);
	}
	
	public Ship(int x, int y, int s)
	{
		this(x, y, 80, 80,s, 6);
	}

	public Ship(int x, int y, int s, int ts)
	{
		this(x, y, 10, 10,s, ts);
	}

	public Ship(int x, int y, int w, int h, int s, int ts)
	{
		super(x, y, w, h);
		setSpeed(s);
		setTorpS(ts);
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
	public void setTorpS(int ts)
	{
		torpS=ts;
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
	
	public void torpedo(Bullets torpedoCluster,Boolean fullSpread) {
		if (fullSpread&&System.currentTimeMillis()-massTricobalt>=10000) {
			massTricobalt = System.currentTimeMillis();
			for (int i=0;i<5;i++) {
				Double angle = Math.atan(1000*Math.random() / (double) this.getY());
				int xs = (int) (torpS*Math.sin(angle-(Math.PI/6))+(Math.random()*4)-2)-1;
				int ys = (int) Math.ceil(torpS*Math.cos(angle+(Math.PI/9))+(Math.random()*4)-2)+2;
				if(Math.floor(Math.random()*2)<=1.0) 
					torpedoCluster.add(new Ammo(this.getX()+25,this.getY()+15,xs,ys));
				else 
					torpedoCluster.add(new Ammo(this.getX()+55,this.getY()+15,xs,ys));		
			}
		}
		else if(System.currentTimeMillis()-tricobalt>=500) {
			double coin=Math.floor(Math.random()*3);
			if (coin <=0.0)
				torpedoCluster.add(new Ammo(getX()+20,getY()+35,0,(int) Math.ceil(torpS+(Math.random()*4)-2)));
			else if(coin <=1.0)
				torpedoCluster.add(new Ammo(getX()+50,getY()+35,0,(int) Math.ceil(torpS+(Math.random()*4)-2)));
			else 
				torpedoCluster.add(new Ammo(getX()+35,getY()+25,0,(int) Math.ceil(torpS+(Math.random()*4)-2)));
			tricobalt = System.currentTimeMillis();
		}
	}
	public void phaser(PhaserBanks bank, int width,Boolean fullSpread) {
		if (fullSpread&&System.currentTimeMillis()-phaserClock>=10000) {
			phaserClock = System.currentTimeMillis();
			for (int i=0;i<4;i++) {
				double coin = Math.floor(Math.random()*3);
				if(coin==1.0) {
					bank.add(new Beam(this.getX()+25,this.getY()+35,(int)(1920*Math.random()),0,(float)(Math.random()*2+0.5)));
				}
				else if (coin==0.0){
					bank.add(new Beam(this.getX()+55,this.getY()+35,(int)(1920*Math.random()),0,(float)(Math.random()*2+0.5)));
				}
				else {
					bank.add(new Beam(this.getX()+40,this.getY()+25,(int)(1920*Math.random()),0,(float)(Math.random()*2+0.5)));
				}
			}
		}	
		else if(!fullSpread&&System.currentTimeMillis()-emitter>=3000) {
			emitter = System.currentTimeMillis();
			bank.add(new Beam(this.getX()+40,this.getY()+25,(int)(1920*Math.random()),0,(float)(Math.random()*2+0.5)));
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
