import java.io.File;
import java.net.URL;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.geom.Line2D;
public class Beam
{
	private int xin, yin, xfin, yfin; 
	private float width;
	private long time;
	public Beam() {
		this(200,450,0,0,1);
	}
	public Beam(int xi, int yi, int xf, int yf) {
		this(xi,yi,xf,yf,1);
	}
	public Beam(int xi, int yi, int xf, int yf, float w) {
		xfin=xf;
		yfin=yf;
		xin=xi;
		yin=yi;
		width=w;
		time=System.currentTimeMillis();
	}
	public void draw(Graphics window) {
		((Graphics2D)window).setStroke(new BasicStroke(width));
		((Graphics2D)window).setColor(Color.ORANGE);
		((Graphics2D)window).draw(new Line2D.Float(xin,yin,xfin,yfin));
	}
	
	public long getTime() {
		return time;
	}
	
	public int xI() {
		return xin;
	}
	public int yI() {
		return yin;
	}
	public int xF() {
		return xfin;
	}
	public int yF() {
		return yfin;
	}
}