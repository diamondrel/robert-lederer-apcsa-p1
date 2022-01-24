//� A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -


import static java.lang.System.*;

public class StarsAndStripes extends StarsRunner
{
   public void starsAndStripes()
   {
      out.println("StarsAndStripes");
      printTwoBlankLines();
   }

   public void printTwentyStars()
   {
	   out.println("********************");
   }

   public void printTwentyDashes()
   {
	   out.println("____________________");
   }

   public void printTwoBlankLines()
   {
	   out.println("");
	   out.println("");
   }
   
   public void printASmallBox()
   {	
	   out.println(" _______");
	   out.println("|\t|");
	   out.println("|\t|");
	   out.println("|\t|");
	   out.println("|_______|");
   }
 
   public void printABigBox()
   { 		
	   out.println(" _______________");
	   out.println("|\t\t|");
	   out.println("|\t\t|");
	   out.println("|\t\t|");
	   out.println("|\t\t|");
	   out.println("|\t\t|");
	   out.println("|\t\t|");
	   out.println("|_______________|");
   }   
}