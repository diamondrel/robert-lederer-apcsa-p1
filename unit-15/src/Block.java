//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		setX(100);
		setY(150);
		setWidth(10);
		setHeight(10);
		setCol(Color.black);
	}
	public Block(int x, int y)
	{
		setX(x);
		setY(y);
		setWidth(10);
		setHeight(10);
		setCol(Color.black);
	}
	public Block(int x, int y, int w, int h)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setCol(Color.black);
	}
	public Block(int x, int y, int w, int h, Color col)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setCol(col);
	}
	
	
	public void setX(int x) {
		xPos=x;
	}
	public void setY(int y) {
		yPos=y;
	}
	public void setWidth(int w) {
		width=w;
	}
	public void setHeight(int h) {
		height=h;
	}
	public void setCol(Color col) {
		color=col;
	}
	public void setPos(int x, int y) {
		xPos=x;
		yPos=y;
	}   
	
	
	public void draw(Graphics window)
	{
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	public void draw(Graphics window, Color col)
	{
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public boolean equals(Object obj)
	{
		Block cB = (Block) obj;
		return (height==cB.getHeight()&&width==cB.getWidth()&&xPos==cB.getX()&&yPos==cB.getY());
	}
	
	
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public String toString() {
		return "X: "+xPos+" - Y: "+yPos+" - Width: "+width+" - Height: "+height+" - Color: "+color.toString();
	}
}