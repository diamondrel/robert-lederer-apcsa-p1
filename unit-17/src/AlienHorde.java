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
			aliens.add(new Alien(x*spacing+((row+1)%2)*(spacing/2)+offset,(row)*60,0));
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
					if(i!=0)
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
				double numer = ((double)(j.yI()-al.getY()));
				double pDenom = ((double)(j.xI()-(al.getX()+25)));
				double nDenom = ((double)(j.xI()-(al.getX()-25)));
				double slope = ((double)((j.yF()-j.yI())/(j.xF()-j.xI())));
				System.out.println("beams size: "+beams.size()+"\naliens size: "+aliens.size()+"\n");
				System.out.println("Alien Number "+i);
				System.out.println("Slope: "+slope);
				//System.out.println("Alien Slope minus: "+(numer/(denom-1))+"\nAlien Slope plus: "+(numer/(denom+1)));
				System.out.println("Numerator: "+numer);
				System.out.println("pDemominator: "+pDenom+"\nDenominator: "+nDenom);
				System.out.println("Alien Slope Positive: "+numer/pDenom+" | Alien Slope Negative: "+numer/nDenom);
				System.out.println("Alien X: "+al.getX()+" | Alien Y: "+al.getY());
				System.out.println("Beam Xi: "+j.xI()+" | Beam Xf: "+j.xF()+" | Beam Yi: "+j.yI()+" | Beam Yf: "+j.yF());
				System.out.println("Dead: "+al.dead());
				if(i!=0&&aliens.size()!=0) {
					if((slope<(numer/pDenom))&&((numer/nDenom)>slope))/*||(slope+0.25>(numer/(denom-1)))&&(slope-0.25<(numer/(denom-1))))*/{
						al.kill();
					}
				}
				System.out.println("");
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
