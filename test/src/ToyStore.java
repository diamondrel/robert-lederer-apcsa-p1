//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import java.util.ArrayList; 

public class ToyStore{
	ArrayList<Toy> toyList;
	public ToyStore() {
		toyList = new ArrayList<Toy>();
	}
	public void loadToys(String str) {
		String[] arr = str.split(" ");
		boolean cont = true;
		for (String i : arr) {
			cont=false;
			toyList.forEach(j->{
				if (j.getName().equals(i)) {
					j.setCount(j.getCount()+1);
				}
			});
			if(!cont) {
				toyList.add(new Toy(i));
			}
			cont=true;
		}
	}
	public void outPrint() {
		toyList.forEach(t->{
			System.out.print(t.getName()+", ");
		});
	}
}