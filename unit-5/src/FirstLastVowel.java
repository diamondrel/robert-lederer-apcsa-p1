//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public String go( String a )
	{
	   char[] ch = new char[a.length()];
	   for (int i = 0; i < a.length(); i++) {
           ch[i] = a.charAt(i);
       }
	   if (Character.isUpperCase(ch[ch.length-1])||Character.isUpperCase(ch[0])) {
		   return "yes";
	   }
	   return "no";
	}
}