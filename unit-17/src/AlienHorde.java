//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
	private int height;

	public AlienHorde(int size,int speed)
	{
		for (int i =0;i<size;i++) {
			aliens.add(new Alien(i*20,40,speed));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien i:aliens) {
			i.draw(window);
		}
	}

	public void moveEmAll()
	{
		 for(Alien i:aliens) {
			 if(i.getX()==0) {
				 
			 }
		 }
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
	}

	public String toString()
	{
		return "";
	}
}
