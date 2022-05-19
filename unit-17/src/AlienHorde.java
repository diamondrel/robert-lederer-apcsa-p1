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
	private List<Alien> aliens=new ArrayList<Alien>();

	public AlienHorde(int size,int speed)
	{
		for (int i=0;i<size;i++) {
			aliens.add(new Alien(i*(800/size),40,speed));
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
			 i.move(null);
		 }
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(int i=0;i<aliens.size();i++) {
			Alien al = aliens.get(i);
			for(Ammo j:shots) {
				if(j.getY()<al.getY()+15&&j.getY()>al.getY()-15&&j.getX()<al.getX()+15&&j.getX()>al.getX()-15) {
					aliens.remove(i);
					i--;
				}
			}
		}
	}

	public String toString()
	{
		return "";
	}
}
