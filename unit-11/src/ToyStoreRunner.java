//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore store = new ToyStore("sorry sorry bat sorry sorry train sorry train train train teddy teddy ball ball ball");
		System.out.println(store.toString());
		System.out.println(store.toString(false));
		System.out.println(store.toString(true));
		System.out.println(store.getMostFrequentToy());
	}
}