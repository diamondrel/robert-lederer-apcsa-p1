//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int x, int y)
	{
		setX(x);
		setY(y);
		setWidth(10);
		setHeight(10);
		setCol(Color.black);
		setXSpeed(3);
		setYSpeed(1);
	}
	public Ball(int x, int y, int w, int h)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setCol(Color.black);
		setXSpeed(3);
		setYSpeed(1);
	}
	public Ball(int x, int y, int w, int h, Color col)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setCol(col);
		setXSpeed(3);
		setYSpeed(1);
	}
	public Ball(int x, int y, int w, int h, Color col, int xS)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setCol(col);
		setXSpeed(xS);
		setYSpeed(1);
	}
	public Ball(int x, int y, int w, int h, Color col, int xS, int yS)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setCol(col);
		setXSpeed(xS);
		setYSpeed(yS);
	}

	public void setXSpeed(int x) {
		xSpeed=x;
	}
	public void setYSpeed(int y) {
		ySpeed=y;
	}

	public void moveAndDraw(Graphics window)
	{
		//draw a white ball at old ball location
		setX(getX()+xSpeed);
		setY(getY()+ySpeed);
		//draw the ball at its new location
	}

	public boolean equals(Object obj)
	{
		Ball ballObj = (Ball)obj;
		return ((super.equals(obj)&&this.getXSpeed()==ballObj.getXSpeed()&&this.getYSpeed()==ballObj.getYSpeed()));
	}   

	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return xSpeed;
	}

	//add a toString() method
}