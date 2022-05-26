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
		int row=0;
		int x=0;
		int spacing = width/size;
		int offset=25;
		for(int i=1;i<=size;i++,x++) {//iterate through every alien
			if(spacing<120) {
				spacing=120;
			}
			if(i%16==1) {
				row++;
				x=0;
			}
			aliens.add(new Alien(x*spacing+((row+1)%2)*(spacing/2)+offset,(row)*60,speed));
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
		for(Beam j:beams) {
			for(int i=0;i<aliens.size();i++) {
				Alien al = aliens.get(i);
				double slope = ((-705.0)/(double)(j.xF()-j.xI()));
				double aSlopeP = (((al.getY()-j.yI())/((al.getX()+25.0)-j.xI())));
				double aSlopeN = (((al.getY()-j.yI())/((al.getX()-25.0)-j.xI())));
				/*System.out.println("Alien "+i);
				System.out.println(j);
				System.out.println(al);
				System.out.println("slope: "+slope);
				System.out.println("pSlope: "+aSlopeP);
				System.out.println("nSlope: "+aSlopeN);
				System.out.println("");*/
				if(aliens.size()!=0||aSlopeP==Double.POSITIVE_INFINITY||aSlopeN==Double.POSITIVE_INFINITY) {
					if(slope<aSlopeP&&slope>aSlopeN) {
						aliens.remove(i);
						i--;
					}
				}
			}
		}
	}
	
	public List<Alien> list(){
		return aliens;
	}

	public String toString()
	{
		return "";
	}
}
