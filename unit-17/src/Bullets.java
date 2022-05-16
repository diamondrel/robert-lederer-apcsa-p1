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

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
	}

	public void add(Ammo al)
	{
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
	}

	public void moveEmAll()
	{
	}

	public void cleanEmUp()
	{
	}

	public List<Ammo> getList()
	{
		return null;
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
		System.out.println("Sin (Y speed): "+3*Math.sin(finalX)+" | Cos (X speed): "+3*Math.cos(finalX));
		return finalX;
	} 

	public String toString()
	{
		return "";
	}
}
