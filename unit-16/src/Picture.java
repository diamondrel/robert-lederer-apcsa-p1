import java.awt.*;
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
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
 
  /** Method to set the picture to only blue */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
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
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
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
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
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
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
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
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
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
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
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
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
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
   for (int row = 0; row < pixels.length-1; row++)
   {
     for (int col = width-1;col >width/2; col--)
     {
       rightPixel = pixels[row][col];
       leftPixel = pixels[row][width - 1 - col];
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
  for (int row = 0; row < pixels.length/2; row++)
  {
    for (int col = 0; col < width; col++)
    {
      topPixel = pixels[row][col];
      bottomPixel = pixels[pixels.length - 1 - row][col];
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
  for (int row = pixels.length/2; row < pixels.length; row++)
  {
    for (int col = 0; col < width; col++)
    {
      bottomPixel = pixels[row][col];
      topPixel = pixels[pixels.length - 1 - row][col];
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
  for (int row = 0;row<width;row++)
  {
    for (int col = 0; col < width; col++)
    {
      leftPixel = pixels[row][col];
      rightPixel = pixels[col][row];
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
  for (int col = 0;col<width;col++)
  {
    for (int row = width-1; row >col; row--)
    {
      leftPixel = pixels[row][col];
      rightPixel = pixels[col][row];
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
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
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
    
    // loop through the rows
    for (int row = 155; row < 196; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 100; col < 200; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
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
    
    // loop through the rows
    for (int row = 230; row < 330; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 230; col < 350; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
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

  /** Method to create a collage of several pictures */
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
    this.write("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\collage.jpg");
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
    this.write("C:\\Users\\ledererr8484\\Desktop\\apcsa-github\\unit-16\\src\\collage.jpg");
  }
  
  /** Method to show large changes in color 
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
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
    	downPixel = pixels[row+1][col];
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
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
	    // loop through the rows
	    for (int row = 365; row < 380; row++)
	    {
	      for (int col = 355; col < 390; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row][col-45];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	      for (int col = 391; col < 405; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row][col-45];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	    }
	    for (int row = 0;row<480;row++) {
	    	for (int col = 0;col<640;col++) {
	    		if(allbg&&(row<150||col<145||col>475)) {
	    			pixels[row][col].setColor(bgPix[row][col].getColor());
	    		}
	    		else if(pixels[row][col].getBlue()>=pixels[row][col].getGreen()&&pixels[row][col].getBlue()>=pixels[row][col].getRed()) {
	    			pixels[row][col].setColor(bgPix[row][col].getColor());
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
  public void steganography(Picture p) {
	Pixel stegPixel = null;
	Pixel pixPixel = null;
	int rTop=-1;
	int rBottom=-1;
	int cLeft=-1;
	int cRight=-1;
    Pixel[][] pPixels = p.getPixels2D();
    Pixel[][] sPixels = getPixels2D();
	int row=0;
	while(rTop==-1) {
		for(int col=0;col<pPixels[0].length;col++) {
//			System.out.println("Row: "+row+" | Col: "+col+" | Pixel Length: "+pPixels[0].length);
			if(pPixels[row][col].getAverage()<100) {
				rTop = row;
			}
		}
		row++;
	}
	row=pPixels.length-1;
	while(rBottom==-1) {
		for(int col=0;col<pPixels[0].length;col++) {
			if(pPixels[row][col].getAverage()<100) {
				rBottom = row;
			}
		}
		row--;
	}
	int col=0;
	while(cLeft==-1) {
		for(row=0;row<pPixels.length;row++) {
			if(pPixels[row][col].getAverage()<100) {
				cLeft = col;
			}
		}
		col++;
	}
	col=pPixels[0].length-1;
	while(cRight==-1) {
		for(row=0;row<pPixels.length;row++) {
			if(pPixels[row][col].getAverage()<100) {
				cRight = col;
			}
		}
		col--;
	}
	sPixels[0][0].setRed(cLeft);
	sPixels[0][0].setGreen(cRight);
	sPixels[0][0].setBlue(rTop);
	sPixels[1][0].setRed(rBottom);
	Color checkColor;
	if(pPixels[rTop][cLeft].getAverage()>100) {
		sPixels[0][2].setColor(new Color(200,200,200));
		checkColor=new Color(255,255,255);
	}
	else{
		sPixels[0][2].setColor(new Color(100,100,100));
		checkColor=new Color(0,0,0);
	}
	int colPlace = 1;
	int colorRun=0;
	int sRow=1;
	int sCol=0;
	for(row=rTop;row<rBottom;row++) {
		boolean cont=true;
//		System.out.println("cLeft: "+cLeft+" cRight: "+cRight+" col: "+col);
		for(col=cLeft;col<cRight;col++) {
			if(cont) {
				if(checkColor.equals(pPixels[row][col].getColor())) {
					colorRun++;
					System.out.println("Row: "+sRow+" | Column: "+sCol+" | Run: "+colorRun+" | Place: "+colPlace);
				}
				else if(colorRun!=0){
					if(colPlace%3==0) {
						sPixels[sRow][sCol].setRed(colorRun);
					}
					else if(colPlace%3==1) {
						sPixels[sRow][sCol].setGreen(colorRun);
					}
					else {
						sPixels[sRow][sCol].setBlue(colorRun);
						sRow++;
					}
					if(sRow==480) {
						sRow=0;
						sCol++;
					}
					if(checkColor.getRed()>pPixels[row][col].getRed()) {
						checkColor=pPixels[row][col].getColor();
					}
					colPlace++;
					colorRun=0;
				}
			}
		}
	}
}
  //make it so each pixel has blue and green used for color run info, and red is only ever <100 and directs to the next pixel
  public static void decrypt() {
	  
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
