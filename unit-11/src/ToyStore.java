//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		loadToys("");
	}
	
	public ToyStore(String toys)
	{
		loadToys(toys);
	}

	public void loadToys( String toys )
	{
		toyList = new ArrayList<Toy>();
		String toylist[] = toys.split(" ",-1);
		for (int i = 0; i<toylist.length;i++) {
			boolean cont = true;
			for (int j = 0; j<toyList.size();j++) {
				if (toylist[i].toString().equals(toyList.get(j).getName())) {
					cont = false;
					toyList.get(j).setCount(-1);
				}
			}
			if (cont) {
				toyList.add(new Toy(toylist[i].toString()));
			}
		}
	}
  
  	public Toy getThatToy( String nm )
  	{
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		int largest = Integer.MIN_VALUE;
  		int largesti = Integer.MIN_VALUE;
  		for (int i =0; i<toyList.size();i++) {
  			if (toyList.get(i).getCount()>largest) {
  				largest = toyList.get(i).getCount();
  				largesti = i;
  			}
  		}
  		return toyList.get(largesti).getName()+ " is the most frequent";
  	}  
  
  	public void sortToysByCount()
  	{
  		Collections.sort(toyList);
  	}  
  	  
	public String toString()
	{
	    return toyList.toString();
	}  	  
	public String toString(boolean ascending)
	{
		if (ascending) {
			sortToysByCount();
		}
		else {
			sortToysByCount();
			Collections.reverse(toyList);
		}
		return toyList.toString();
	}
}