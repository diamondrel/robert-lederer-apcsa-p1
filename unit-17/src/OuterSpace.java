//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Boolean galaga = true;
	private Boolean advWeapons = true;
	private Alien alienOne;
	private Alien alienTwo;

	/* uncomment once you are ready for this part
	 *
   private AlienHorde horde;
	private Bullets shots;
	*/

	private boolean[] keys;
	private BufferedImage back;
	private Bullets photonTorpedos;
	private PhaserBanks bank;
	
	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[8];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship();
		photonTorpedos = new Bullets();
		bank = new PhaserBanks();
//		alienOne = new Alien();
//		alienTwo = new Alien(60,20);
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;
		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		ship.draw(graphToBack);
		photonTorpedos.drawEmAll(graphToBack);
		photonTorpedos.moveEmAll();
		photonTorpedos.cleanEmUp();
		bank.drawEmAll(graphToBack);
		bank.cleanEmUp();
//		alienOne.draw(graphToBack);
//		alienTwo.draw(graphToBack);
		if (keys[0]) {
			ship.move("L");
		}
		if (keys[1]) {
			ship.move("R");
		}
		if (keys[2]&&!galaga) {
			ship.move("N");
		}
		if (keys[3]&&!galaga) {
			ship.move("S");
		}
		if (keys[4]) {
			ship.torpedo(photonTorpedos,false);
		}
		if (keys[5]) {
			if (advWeapons) {
				ship.phaser(bank,1,true);
			}
			else
				ship.torpedo(photonTorpedos,false);
		}
		if (keys[6]) {
			if (advWeapons)
				ship.torpedo(photonTorpedos,true);
			else
				ship.torpedo(photonTorpedos,false);
		}
		if (keys[7]) {
			if(advWeapons)
				ship.phaser(bank,1,false);
			else
				ship.torpedo(photonTorpedos, false);
		}
		//add code to move Ship, Alien, etc.


		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship


		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[1] = true;
		}if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[2] = true;
		}if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_F)
		{
			keys[5] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			keys[6] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[7] = true;
		}
		
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[1] = false;
		}if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[2] = false;
		}if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[5] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			keys[6] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[7] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
           repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

