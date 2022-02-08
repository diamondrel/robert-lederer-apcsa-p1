//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private char playChoice;
	private char compChoice;

	public RockPaperScissors()
	{
		playChoice='N';
	}

	public RockPaperScissors(char player)
	{
	}

	public void setPlayers(char player)
	{
		Scanner keyboard = new Scanner(System.in);
		char playVar = player;
		while(playChoice=='N') {
			if ((playVar == 'R')||(playVar =='P')||(playVar =='S')) {
				playChoice = playVar;
			}
			else {
				System.out.println("Invalid choice, try again");
				out.print("type in your prompt [R,P,S] :: ");
				playVar = keyboard.next().charAt(0);
			}
		}
		int x = (int)Math.floor(Math.random()*2);
		if(x == 0) {
			compChoice = 'R';
		}
		else if(x == 1) {
			compChoice = 'P';
		}
		else if(x == 2) {
			compChoice = 'S';
		}
		else {
			compChoice = 'N';
		}
	}

	public String determineWinner()
	{
		String winner;
		if ((playChoice == 'R' &&compChoice == 'R')||(playChoice == 'P'&&compChoice=='P')||(playChoice == 'S'&&compChoice=='S')) {
			winner = "Draw!";
		}
		else if ((playChoice == 'R' &&compChoice == 'P')||(playChoice == 'P' &&compChoice == 'S')||(playChoice == 'S' &&compChoice == 'R')) {
			winner = "Computer wins!";
		}
		else if ((playChoice == 'R' &&compChoice == 'S')||(playChoice == 'P' &&compChoice == 'R')||(playChoice == 'S' &&compChoice == 'P')) {
			winner = "Player wins!";
		}
		else {
			winner = "Error Code Walnut: No Outcome";
		}
		out.println("The Computer Chose "+compChoice);
		return winner;
	}

	public String toString()
	{
		String output="";
		return output;
	}
}