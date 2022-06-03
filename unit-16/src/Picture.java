import java.awt.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
        pixelObj.setBlue(0);
      }
    }
  }
 
  /** Method to set the picture to only blue */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method to set the picture to only blue */
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
        pixelObj.setBlue(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method to set the picture to only blue */
  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
        pixelObj.setRed(0);
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the picture to only blue */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }
  
  /** Method to set the picture to only blue */
  public void greyscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
    	int val = (pixelObj.getRed()+pixelObj.getBlue()+pixelObj.getGreen())/3;
        pixelObj.setRed(val);
        pixelObj.setGreen(val);
        pixelObj.setBlue(val);
      }
    }
  }
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] row1Array : pixels)
    {
      for (Pixel pixelObj : row1Array)
      {
    	pixelObj.setRed((pixelObj.getRed()+pixelObj.getBlue()+pixelObj.getGreen())/3);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row1 = 0; row1 < pixels.length; row1++)
    {
      for (int col1 = 0; col1 < width / 2; col1++)
      {
        leftPixel = pixels[row1][col1];
        rightPixel = pixels[row1][width - 1 - col1];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  /** Method that mirrors the picture around a 
   * vertical mirror in the center of the picture
   * from left to right */
 public void mirrorRightToLeftVertical()
 {
   Pixel[][] pixels = this.getPixels2D();
   Pixel leftPixel = null;
   Pixel rightPixel = null;
   int width = pixels[0].length;
   for (int row1 = 0; row1 < pixels.length-1; row1++)
   {
     for (int col1 = width-1;col1 >width/2; col1--)
     {
       rightPixel = pixels[row1][col1];
       leftPixel = pixels[row1][width - 1 - col1];
       leftPixel.setColor(rightPixel.getColor());
     }
   } 
 }
 /** Method that mirrors the picture around a 
  * vertical mirror in the center of the picture
  * from left to right */
public void mirrorHorizontal()
{
  Pixel[][] pixels = this.getPixels2D();
  Pixel topPixel = null;
  Pixel bottomPixel = null;
  int width = pixels[0].length;
  for (int row1 = 0; row1 < pixels.length/2; row1++)
  {
    for (int col1 = 0; col1 < width; col1++)
    {
      topPixel = pixels[row1][col1];
      bottomPixel = pixels[pixels.length - 1 - row1][col1];
      bottomPixel.setColor(topPixel.getColor());
    }
  } 
}
public void mirrorBotToTop()
{
  Pixel[][] pixels = this.getPixels2D();
  Pixel topPixel = null;
  Pixel bottomPixel = null;
  int width = pixels[0].length;
  for (int row1 = pixels.length/2; row1 < pixels.length; row1++)
  {
    for (int col1 = 0; col1 < width; col1++)
    {
      bottomPixel = pixels[row1][col1];
      topPixel = pixels[pixels.length - 1 - row1][col1];
      topPixel.setColor(bottomPixel.getColor());
    }
  } 
}

public void mirrorDiagonal()
{
  Pixel[][] pixels = this.getPixels2D();
  Pixel rightPixel = null;
  Pixel leftPixel = null;
  int width = pixels.length;
  for (int row1 = 0;row1<width;row1++)
  {
    for (int col1 = 0; col1 < width; col1++)
    {
      leftPixel = pixels[row1][col1];
      rightPixel = pixels[col1][row1];
      rightPixel.setColor(leftPixel.getColor());
    }
  } 
}
public void mirrorDiagonalTwo()
{
  Pixel[][] pixels = this.getPixels2D();
  Pixel rightPixel = null;
  Pixel leftPixel = null;
  int width = pixels.length;
  for (int col1 = 0;col1<width;col1++)
  {
    for (int row1 = width-1; row1 >col1; row1--)
    {
      leftPixel = pixels[row1][col1];
      rightPixel = pixels[col1][row1];
      rightPixel.setColor(leftPixel.getColor());
    }
  } 
}
 
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the row1s
    for (int row1 = 27; row1 < 97; row1++)
    {
      // loop from 13 to just before the mirror point
      for (int col1 = 13; col1 < mirrorPoint; col1++)
      {
        
        leftPixel = pixels[row1][col1];      
        rightPixel = pixels[row1]                       
                         [mirrorPoint - col1 + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorArms()
  {
    int mirrorPoint = 204;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the row1s
    for (int row1 = 155; row1 < 196; row1++)
    {
      // loop from 13 to just before the mirror point
      for (int col1 = 100; col1 < 200; col1++)
      {
        
        leftPixel = pixels[row1][col1];      
        rightPixel = pixels[row1]                       
                         [mirrorPoint - col1 + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorGull()
  {
    int mirrorPoint = 354;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the row1s
    for (int row1 = 230; row1 < 330; row1++)
    {
      // loop from 13 to just before the mirror point
      for (int col1 = 230; col1 < 350; col1++)
      {
        
        leftPixel = pixels[row1][col1];      
        rightPixel = pixels[row1]                       
                         [mirrorPoint - col1 + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row1 to copy to
    * @param startCol the start col1 to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
public void copyTwo(Picture fromPic, int startRow, int startCol,int stopRow,int stopCol){
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = 0, toRow = startRow; fromRow < stopRow && toRow < stopRow; fromRow++, toRow++){
		for (int fromCol = 0, toCol = startCol; fromCol < stopCol && toCol < stopCol;fromCol++, toCol++){
			fromPixel = fromPixels[fromRow][fromCol];
			toPixel = toPixels[toRow][toCol];
			toPixel.setColor(fromPixel.getColor());
		}
	}   
}

  /** Method to create a col1lage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\flower1.jpg");
    Picture flower2 = new Picture("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\col1lage.jpg");
  }
  
  public void createCollageTwo()
  {
    Picture flower1 = new Picture("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\flower1.jpg");
    Picture flower2 = new Picture("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\flower2.jpg");
    this.copyTwo(flower1,0,0,10,10);
    this.copyTwo(flower2,100,0,130,20);
    this.copyTwo(flower1,200,0,210,30);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copyTwo(flowerNoBlue,300,0,360,10);
    this.copyTwo(flower1,400,0,420,10);
    this.copyTwo(flower2,500,0,550,30);
    this.mirrorVertical();
    this.write("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\col1lage.jpg");
  }
  
  /** Method to show large changes in col1or 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color downColor = null;
    for (int row1 = 0; row1 < pixels.length-1; row1++)
    {
      for (int col1 = 0; col1 < pixels[0].length-1; col1++)
      {
    	downPixel = pixels[row1+1][col1];
        leftPixel = pixels[row1][col1];
        rightPixel = pixels[row1][col1+1];
        rightColor = rightPixel.getColor();
        downColor = downPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist||leftPixel.colorDistance(downColor)>edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void backgroundSwap()
  {
	  System.out.println("Property of Robert Lederer, All Rights Reserved\nPeriod 1, Computer 08, 5/17/2022");
	    Picture bg = new Picture("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\moon-surface.jpg");
	    Pixel[][] bgPix = bg.getPixels2D();
	    Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Boolean allbg=false;
	    // loop through the row1s
	    for (int row1 = 365; row1 < 380; row1++)
	    {
	      for (int col1 = 355; col1 < 390; col1++)
	      {
	        
	        leftPixel = pixels[row1][col1];      
	        rightPixel = pixels[row1][col1-45];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	      for (int col1 = 391; col1 < 405; col1++)
	      {
	        
	        leftPixel = pixels[row1][col1];      
	        rightPixel = pixels[row1][col1-45];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	    }
	    for (int row1 = 0;row1<480;row1++) {
	    	for (int col1 = 0;col1<640;col1++) {
	    		if(allbg&&(row1<150||col1<145||col1>475)) {
	    			pixels[row1][col1].setColor(bgPix[row1][col1].getColor());
	    		}
	    		else if(pixels[row1][col1].getBlue()>=pixels[row1][col1].getGreen()&&pixels[row1][col1].getBlue()>=pixels[row1][col1].getRed()) {
	    			pixels[row1][col1].setColor(bgPix[row1][col1].getColor());
	    		}
	    	}
	    }
	  }
  public void opacitize() {
	  for(int i=0;i<240;i++) {
		  getPixels2D()[i][i].setAlpha(211);
	  }
	  System.out.println(getPixels2D()[50][50].getAlpha());
  }
  public void manualSten(Picture p) {
	  		Pixel[][] pPixels = p.getPixels2D();
		    Pixel[][] sPixels = getPixels2D();
			Boolean white = true;
			Color checkColor=new Color(255,255,255);
			Color oCheck=checkColor;
			if(sPixels[0][0].getAverage()>50) {
				oCheck = new Color(255,255,255);
			}
			else {
				oCheck = new Color(0,0,0);
		  }

			int run=0;
			List<Integer> runs=new ArrayList<Integer>();
			for(int row1=0;row1<pPixels.length;row1++) {
				for(int col1=0;col1<pPixels[0].length;col1++) {
					if(white&&pPixels[row1][col1].getAverage()>120) {
						run++;
					}
					else if(!white&&pPixels[row1][col1].getAverage()<120) {
						run++;
					}
					else {
						while(run>255) {
							runs.add(255);
							runs.add(0);
							run-=255;
						}
						runs.add(run);
						white=!white;
						run=1;
					}
				}
			}
			System.out.println(runs);
			Picture messagePicture = new Picture(p.getHeight(),p.getWidth());
			Pixel[][] mPixels = messagePicture.getPixels2D();
			int col1=0;
			int row1=0;
			Color theCol=Color.white;
			for(int i=0;i<runs.size();i++) {
				for(int j=0;j<runs.get(i);j++) {
					col1++;
					if(col1>=p.getWidth()) {
						col1=0;
						row1++;
					}
					mPixels[row1][col1].setColor(theCol);
				}
				if(theCol.equals(Color.white))
					theCol=Color.black;
				else if(theCol.equals(Color.black))
					theCol=Color.white;
			}
			messagePicture.explore();
  }
  public void steganography(Picture p) {
    Pixel[][] pPixels = p.getPixels2D();
    Pixel[][] sPixels = getPixels2D();
	Boolean white = true;
	Color oCheck;
	if(pPixels[0][0].getAverage()>50) {
		oCheck = new Color(255,255,255);
	}
	else {
		oCheck = new Color(0,0,0);
    }

	int run=0;
	List<Integer> runs=new ArrayList<Integer>();
	for(int row1=0;row1<pPixels.length;row1++) {
		for(int col1=0;col1<pPixels[0].length;col1++) {
			if(white&&pPixels[row1][col1].getAverage()>120) {
				run++;
			}
			else if(!white&&pPixels[row1][col1].getAverage()<120) {
				run++;
			}
			else {
				while(run>255) {
					runs.add(255);
					runs.add(0);
					run-=255;
				}
				runs.add(run);
				white=!white;
				run=1;
			}
		}
	}
	
	System.out.println(runs);
	
	/*Picture messagePicture = new Picture(p.getHeight(),p.getWidth());
	Pixel[][] mPixels = messagePicture.getPixels2D();
	int col1=0;
	int row1=0;
	Color theCol=Color.white;
	for(int i=0;i<runs.size();i++) {
		for(int j=0;j<runs.get(i);j++) {
			col1++;
			if(col1>=p.getWidth()) {
				col1=0;
				row1++;
			}
			mPixels[row1][col1].setColor(theCol);
		}
		if(theCol.equals(Color.white))
			theCol=Color.black;
		else if(theCol.equals(Color.black))
			theCol=Color.white;
	}
	messagePicture.explore();*/
	List<Coordinate> takenCoords = new ArrayList<Coordinate>();
	List<Integer> takenCol=new ArrayList<Integer>();
	List<Integer> takenRow=new ArrayList<Integer>();
	takenCoords.add(new Coordinate(0,0));
	takenCol.add(0);
	takenRow.add(0);
	Calendar calendar = Calendar.getInstance();
	long front = calendar.getTimeInMillis();
	for(int i=0;i<runs.size();i++) {
		System.out.println(i);
		int bestCol=255;
		int bestRow=255;
		int r = takenCoords.get(takenCoords.size()-1).getRow();
		int g = takenCoords.get(takenCoords.size()-1).getCol();
		int b = runs.get(i);
		int bdifference=255;
		int bdifferenceL=255;
		for(int row=1;row<256;row++) {
			for(int col=0;col<256;col++) {
				boolean taken=false;
				int j=0;
				while(!taken&&j<takenCoords.size()) {
					taken=takenCoords.get(j).getRow()==row&&takenCoords.get(j).getCol()==col;
					j++;
				}
				if (!taken) {
					if(r>=g && r>=b) {
						bdifference=Math.abs(sPixels[row][col].getRed()-r);
						if(bdifference<bdifferenceL) {
//							System.out.println(row+", "+col);
							bestRow=row;
							bestCol=col;
							bdifferenceL=bdifference;
						}
					}
					else if (g>=r && g>=b) {
						bdifference=Math.abs(sPixels[row][col].getGreen()-g);
						if(bdifference<bdifferenceL) {
//							System.out.println(row+", "+col);
							bestRow=row;
							bestCol=col;
							bdifferenceL=bdifference;
						}
					}
					else {
						bdifference=Math.abs(sPixels[row][col].getBlue()-b);
						if(bdifference<bdifferenceL) {
//							System.out.println(row+", "+col);
							bestRow=row;
							bestCol=col;
							bdifferenceL=bdifference;
						}
					}
				}
			}
		}
		sPixels[bestRow][bestCol].setColor(new Color(r,g,b));
		takenCoords.add(new Coordinate(bestRow,bestCol));
		takenRow.add(bestRow);
		takenCol.add(bestCol);
	}
	System.out.println(takenCoords.toString());
	System.out.println(p.getWidth());
	System.out.println(p.getHeight());
	sPixels[0][0].setColor(new Color(120,255,255));
	sPixels[0][1].setColor(new Color(120,p.getHeight()-255,255));
	sPixels[0][2].setColor(new Color(120,0,p.getWidth()-(2*255)));
	sPixels[0][3].setColor(new Color(oCheck.getRed(),takenCoords.get(takenCoords.size()-1).getRow(),takenCoords.get(takenCoords.size()-1).getCol()));
	System.out.println(calendar.getTimeInMillis()-front);
  }
  
  public void decrypt() {
	  Pixel[][] sPixels = getPixels2D();
	  int height = sPixels[0][0].getGreen()+sPixels[0][1].getGreen()+sPixels[0][2].getGreen();
	  int width = sPixels[0][0].getBlue()+sPixels[0][1].getBlue()+sPixels[0][2].getBlue();
	  Picture messagePicture = new Picture(height,width);
		Pixel[][] mPixels = messagePicture.getPixels2D();
	  Color theCol;
	  List<Integer> runs=new ArrayList<Integer>();
	  if(sPixels[0][3].getRed()>=120) {
		  theCol=new Color(255,255,255);
	  }
	  else {
		  theCol=new Color(0,0,0);
	  }
	  int row=sPixels[0][3].getGreen();
	  int col=sPixels[0][3].getBlue();
	  while(!(row==0&&col==0)) {
		  runs.add(sPixels[row][col].getBlue());
		  int curRow=row;
		  int curCol=col;
		  row=sPixels[curRow][curCol].getRed();
		  col=sPixels[curRow][curCol].getGreen();
	  }
	  System.out.println(runs);
	  Collections.reverse(runs);
	  int col1=0,row1=0;
		for(int i=0;i<runs.size();i++) {
			for(int j=0;j<runs.get(i);j++) {
				col1++;
				if(col1>=width) {
					col1=0;
					row1++;
				}
				mPixels[row1][col1].setColor(theCol);
			}
			if(theCol.equals(Color.white))
				theCol=Color.black;
			else if(theCol.equals(Color.black))
				theCol=Color.white;
		}
		System.out.println(runs);
		messagePicture.explore();
  }
  
  public void decryptTwo() {
	  int[] runThing = new int[] {19, 79, 21, 9, 0, 255, 0, 255, 26, 71, 27, 3, 0, 255, 0, 255, 32, 64, 33, 253, 0, 255, 40, 55, 40, 248, 0, 255, 45, 49, 44, 245, 0, 255, 50, 43, 49, 241, 0, 255, 57, 33, 56, 237, 0, 255, 63, 24, 63, 234, 0, 255, 71, 11, 70, 232, 0, 255, 154, 229, 0, 255, 158, 226, 0, 255, 160, 224, 0, 255, 162, 221, 0, 255, 166, 218, 0, 255, 168, 216, 0, 255, 170, 213, 0, 255, 174, 210, 0, 255, 176, 208, 0, 255, 178, 206, 0, 255, 179, 205, 0, 255, 182, 202, 0, 255, 184, 200, 0, 255, 186, 198, 0, 255, 187, 196, 0, 255, 191, 194, 0, 255, 192, 192, 0, 255, 193, 190, 0, 255, 196, 189, 0, 255, 198, 186, 0, 255, 199, 185, 0, 255, 201, 184, 0, 255, 202, 181, 0, 255, 205, 179, 0, 255, 207, 178, 0, 255, 208, 176, 0, 255, 209, 176, 0, 255, 210, 173, 0, 255, 213, 172, 0, 255, 214, 170, 0, 255, 216, 169, 0, 255, 216, 168, 0, 255, 218, 166, 0, 255, 219, 165, 0, 255, 222, 163, 0, 255, 222, 162, 0, 255, 224, 161, 0, 255, 224, 160, 0, 255, 226, 159, 0, 255, 226, 158, 0, 255, 229, 155, 0, 255, 230, 155, 0, 255, 231, 153, 0, 255, 232, 153, 0, 255, 232, 152, 0, 255, 234, 151, 0, 255, 234, 151, 0, 255, 235, 150, 0, 255, 236, 150, 0, 255, 235, 153, 0, 255, 233, 154, 0, 255, 231, 156, 0, 255, 229, 158, 0, 255, 228, 159, 0, 255, 226, 161, 0, 255, 224, 163, 0, 255, 222, 164, 0, 255, 223, 163, 0, 255, 222, 165, 0, 255, 220, 166, 0, 255, 220, 166, 0, 255, 219, 168, 0, 255, 217, 169, 0, 255, 216, 170, 0, 255, 216, 170, 0, 255, 215, 172, 0, 255, 213, 172, 0, 255, 213, 173, 0, 255, 212, 174, 0, 255, 212, 174, 0, 255, 212, 173, 0, 255, 212, 174, 0, 255, 211, 174, 0, 255, 211, 175, 0, 255, 210, 176, 0, 255, 209, 177, 0, 255, 208, 177, 0, 255, 209, 176, 0, 255, 209, 177, 0, 255, 208, 177, 0, 255, 208, 177, 0, 255, 208, 177, 0, 255, 208, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 179, 0, 255, 206, 179, 0, 255, 206, 179, 0, 255, 206, 179, 0, 255, 206, 178, 0, 255, 207, 179, 0, 255, 206, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 177, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 178, 0, 255, 207, 177, 0, 255, 208, 177, 0, 255, 208, 177, 0, 255, 207, 176, 0, 255, 208, 177, 0, 255, 208, 176, 0, 255, 209, 176, 0, 255, 209, 176, 0, 255, 208, 176, 0, 255, 209, 174, 0, 255, 211, 174, 0, 255, 211, 173, 0, 255, 211, 173, 0, 255, 212, 173, 0, 255, 211, 172, 0, 255, 212, 172, 0, 255, 213, 171, 0, 255, 213, 171, 0, 255, 214, 170, 0, 255, 214, 170, 0, 255, 215, 168, 0, 255, 215, 169, 0, 255, 216, 168, 0, 255, 216, 166, 0, 255, 218, 166, 0, 255, 219, 165, 0, 255, 218, 165, 0, 255, 219, 164, 0, 255, 221, 162, 0, 255, 222, 165, 0, 255, 218, 168, 0, 255, 216, 170, 0, 255, 215, 172, 0, 255, 211, 175, 0, 255, 209, 177, 0, 255, 207, 180, 0, 255, 203, 183, 0, 255, 200, 186, 0, 255, 198, 190, 0, 255, 193, 193, 0, 255, 191, 196, 0, 255, 95, 2, 90, 200, 0, 255, 84, 18, 80, 205, 0, 255, 79, 24, 75, 209, 0, 255, 74, 30, 70, 215, 0, 255, 66, 38, 63, 221, 0, 255, 60, 44, 57, 227, 0, 255, 53, 51, 51, 235, 0, 255, 43, 25, 11, 25, 40, 247, 0, 255, 31, 26, 16, 29, 31, 7, 0, 255, 0, 255, 11, 33, 19, 37, 13, 57, 0, 255, 0, 255, 24, 103, 0, 255, 0, 255, 27, 101, 0, 255, 0, 255, 29, 98, 0, 255, 0, 255, 32, 97, 0, 255, 0, 255, 33, 95, 0, 255, 0, 255, 35, 93, 0, 255, 0, 255, 36, 92, 0, 255, 0, 255, 38, 91, 0, 255, 0, 255, 39, 90, 0, 255, 0, 255, 40, 88, 0, 255, 0, 255, 42, 87, 0, 255, 0, 255, 43, 86, 0, 255, 0, 255, 42, 87, 0, 255, 0, 255, 43, 86, 0, 255, 0, 255, 44, 85, 0, 255, 0, 255, 44, 85, 0, 255, 0, 255, 45, 84, 0, 255, 0, 255, 46, 83, 0, 255, 0, 255, 46, 83, 0, 255, 0, 255, 47, 83, 0, 255, 0, 255, 46, 83, 0, 255, 0, 255, 46, 83, 0, 255, 0, 255, 46, 83, 0, 255, 0, 255, 47, 82, 0, 255, 0, 255, 47, 83, 0, 255, 0, 255, 46, 84, 0, 255, 0, 255, 45, 84, 0, 255, 0, 255, 45, 85, 0, 255, 0, 255, 44, 86, 0, 255, 0, 255, 43, 85, 0, 255, 0, 255, 44, 86, 0, 255, 0, 255, 43, 87, 0, 255, 0, 255, 42, 88, 0, 255, 0, 255, 40, 89, 0, 255, 0, 255, 40, 90, 0, 255, 0, 255, 39, 91, 0, 255, 0, 255, 37, 93, 0, 255, 0, 255, 36, 94, 0, 255, 0, 255, 35, 95, 0, 255, 0, 255, 32, 98, 0, 255, 0, 255, 31, 99, 0, 255, 0, 255, 28, 102, 0, 255, 0, 255, 26, 104, 0, 255, 0, 255, 24, 106, 0, 255, 0, 255, 21, 109, 0, 255, 0, 255, 17, 113, 0, 255, 0, 255, 14, 116, 0, 255, 0, 255, 10, 156, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255};
	  
	  Pixel[][] sPixels = getPixels2D();
	  //int height = sPixels[0][0].getGreen()+sPixels[0][1].getGreen()+sPixels[0][2].getGreen();
	  //int width = sPixels[0][0].getBlue()+sPixels[0][1].getBlue()+sPixels[0][2].getBlue();
	  int height=480;
	  int width=640;
	  Picture messagePicture = new Picture(height,width);
		Pixel[][] mPixels = messagePicture.getPixels2D();
	  Color theCol=new Color(255,255,255);
	  List<Integer> runs=new ArrayList<Integer>();
	  /*int row=sPixels[0][3].getGreen();
	  int col=sPixels[0][3].getBlue();
	  while(!(row==0&&col==0)) {
		  runs.add(sPixels[row][col].getBlue());
		  int curRow=row;
		  int curCol=col;
		  row=sPixels[curRow][curCol].getRed();
		  col=sPixels[curRow][curCol].getGreen();
	  }
	  System.out.println(runs);*/
	  for(int i:runThing) {
		  runs.add(i);
	  }

      Collections.reverse(runs);
	  int col1=0,row1=0;
		for(int i=0;i<runs.size();i++) {
			for(int j=0;j<runs.get(i);j++) {
				col1++;
				if(col1>=width) {
					col1=0;
					row1++;
				}
				mPixels[row1][col1].setColor(theCol);
			}
			if(theCol.equals(Color.white))
				theCol=Color.black;
			else if(theCol.equals(Color.black))
				theCol=Color.white;
		}
		System.out.println(runs);
		messagePicture.explore();
  }

  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  /*public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }*/
  
} // this } is the end of class Picture, put all new methods before this
