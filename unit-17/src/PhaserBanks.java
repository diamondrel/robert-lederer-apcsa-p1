import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.geom.Line2D;
public class PhaserBanks
{
	private List<Beam> phaser;
	
	public PhaserBanks() {
		phaser = new ArrayList<Beam>();
	}
	public void add(Beam n) {
		phaser.add(n);
	}
	public void drawEmAll( Graphics window )
	{
		for(Beam i:phaser) {
			i.draw(window);
		}
	}
	public void cleanEmUp()
	{
		for(int i =0;i<phaser.size();i++) {
			if (System.currentTimeMillis()-phaser.get(i).getTime()>=333) {
				phaser.remove(i);
				i--;
			}
		}
	}
	public List<Beam> getList(){
		return phaser;
	}
}
