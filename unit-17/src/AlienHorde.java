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
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class AlienHorde
{
	boolean finished=false;
	private List<Alien> aliens=new ArrayList<Alien>();

	public AlienHorde(int size,int speed,int width)
	{
		int y=1;
		int j=1;
		int c=1;
		for(int i=1;i<=size;i++) {//iterate through every alien
			
			if(i>size/c) {
				if(((size/c)*50)>width/3) { //ensure it's not too cramped
					c++;
				}
				y++;
				j=1;
			}
			add(new Alien(j*60,y*40,speed));
			j++;
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
		while(finished) {
			window.drawString("YOU WIN!!",920,540);
		}
		done(window);
	}

	public void moveEmAll()
	{
		 for(Alien i:aliens) {
			 i.move(null);
		 }
	}
	public void moveEmAll(int width, int height)
	{
		 for(Alien i:aliens) {
			 i.move(width,height);
		 }
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(int i=0;i<aliens.size();i++) {
			Alien al = aliens.get(i);
			for(Ammo j:shots) {
				if(j.getY()<al.getY()+20&&j.getY()>al.getY()-20&&j.getX()<al.getX()+20&&j.getX()>al.getX()-20) {
					aliens.remove(i);
					i--;
				}
			}
		}
	}
	public void removeDeadOne(List<Beam> beams)
	{
		for(int i=0;i<aliens.size();i++) {
			Alien al = aliens.get(i);
			for(Beam j:beams) {
				int slope = ((j.yF()-j.yI())/(j.xF()-j.xI()));
				if()
				if(slope==(j.yF()-al.getY())/(j.xF()-al.getX()+15)||slope==(j.yF()-al.getY())/(j.xF()-al.getX()-15)) {
					if(i!=0) {
						aliens.remove(i);
						i--;
					}
				}
			}
		}
	}
	
	public void done( Graphics window ) {
		if(aliens.size()==0) {
			finished=true;
		}
	}

	public String toString()
	{
		return "";
	}
}
