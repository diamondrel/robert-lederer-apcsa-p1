//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		//call set
	}

	//add in second constructor
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		for (int i = 0; i<sentence.length();i++) {
			System.out.println(sentence);
			if (sentence.charAt(i)==lookFor) {
				System.out.println(sentence.substring(0,i-1));
				System.out.println(sentence.substring(i,sentence.length()-1));
				sentence = sentence.substring(0,i-1)+sentence.substring(i,sentence.length()-1);
				i--;
			}
		}
		String cleaned=sentence;
		return cleaned;
	}

	public String toString()
	{
		return "original sentence: " + sentence + " - letter to remove: " + lookFor + " - cleaned sentence: " + removeLetters();
	}
}