public class tester{
	public static String abMethod(String a, String b) {
		int x = a.indexOf(b);
		while(x>=0) {
			a=a.substring(0,x)+a.substring(x+b.length());
			x=a.indexOf(b);
		}
		return a;
	}
}