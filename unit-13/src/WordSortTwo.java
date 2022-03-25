//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence) {
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		String temp = "";
		Boolean cont = false;
		for (int k=0;k<wordRay.length;k++) {
		for (int i =0;i<wordRay.length-1;i++) {
			cont = true;
			int j = 0;
			while (j<wordRay[i].length()&&cont) {
				if (wordRay[i].charAt(j)<wordRay[i+1].charAt(j)) {
					cont = false;
				}
				else if (wordRay[i].charAt(j)>wordRay[i+1].charAt(j)) {
					temp = wordRay[i];
					wordRay[i]=wordRay[i+1];
					wordRay[i+1]=temp;
					cont = false;
				}
				else {
					j++;
				}
			}
		}
		}
	}

	public String toString()
	{
		String output="";
		for (int i = 0;i<wordRay.length;i++) {
			output+=wordRay[i]+"\n";
		}
		return output;
	}
}