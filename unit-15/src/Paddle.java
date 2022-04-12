//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block{
	//instance variables
	private int speed;

	public Paddle(){
		super(10,10);
		speed=5;
	}
	public Paddle(int x,int y) {
		super(x,y);
		speed=5;
	}
	public Paddle(int x,int y, int vel) {
		super(x,y);
		speed=vel;
	}
	public Paddle(int x,int y, int width, int height, int vel) {
		super(x,y,width,height);
		speed=vel;
	}
	public Paddle(int x,int y, int width, int height, Color col, int vel) {
		super(x,y,width,height,col);
		speed=vel;
	}
	public void moveUpAndDraw(Graphics window){

	}

	public void moveDownAndDraw(Graphics window){

	}

	public int getSpeed() {
		return speed;
	}
	
	public String toString() {
		return super.toString()+" - Speed: "+speed;
	}
}