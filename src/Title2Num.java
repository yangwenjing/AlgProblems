
public class Title2Num {
	public int titleToNumber(String s) {
     
		s=s.toUpperCase();//×ª»»
		int i = 0;
		int number=0;
		while(i<s.length())
		{
			char c = s.charAt(i);
			number = number*26+this.print10Char(c);
			i++;
		}
		
		return number;
    }
	
	public int print10Char(char c)
	{
		int num = (c>>0)-64;
		return num;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABA";
		Title2Num t2n = new Title2Num();
		int x = t2n.titleToNumber(s);
		System.out.println(x);
	}

}
