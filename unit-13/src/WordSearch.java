//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m=new String[size][size];
    	for (int i=0;i<size;i++) {
    		for(int k=0;k<size;k++) {
    			m[i][k]=str.substring((i*size)+k,(i*size)+k+1);
    			System.out.print(m[i][k]+" ");
    		}
    		System.out.println("");
    	}
    }

    public boolean isFound( String word )
    {
    	for(int i=0;i<m.length;i++) {
    		for (int j=0;j<m[i].length;j++) {
    			if(checkRight(word,i,j)||checkLeft(word,i,j)||checkUp(word,i,j)||checkDown(word,i,j)||checkDiagUpRight(word,i,j)||checkDiagDownRight(word,i,j)||checkDiagUpLeft(word,i,j)||checkDiagDownLeft(word,i,j)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

	public boolean checkRight(String w, int r, int c)
   {
		String result="";
		for (int i = 0;i<w.length();i++) {
			if (c+i<m[0].length)
				result += m[r][c+i];
			else
				return false;
		}
		if(result.equals(w)) 
			return true;
		return false;
	}

	public boolean checkLeft(String w, int r, int c)
	{
		String result="";
		for (int i = 0;i<w.length();i++) {
			if (c-i>0)
				result += m[r][c-i];
			else
				return false;
		}
		if(result.equals(w)) 
			return true;
		return false;
	}

	public boolean checkUp(String w, int r, int c)
	{
		String result="";
		for (int i = 0;i<w.length();i++) {
			if (r-i>0)
				result += m[r-i][c];
			else
				return false;
		}
		if(result.equals(w)) 
			return true;
		return false;
	}

	public boolean checkDown(String w, int r, int c)
	{
		String result="";
		for (int i = 0;i<w.length();i++) {
			if (r+i<m[0].length)
				result += m[r+i][c];
			else
				return false;
		}
		if(result.equals(w)) 
			return true;
		return false;
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		String result="";
		for (int i = 0;i<w.length();i++) {
			if ((r-i>0)&&(c+i<m[0].length))
				result += m[r-i][c+i];
			else
				return false;
		}
		if(result.equals(w)) 
			return true;
		return false;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		return false;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		return false;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		return false;
	}

    public String toString()
    {
 		return "";
    }
}
