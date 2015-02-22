
public class Num2Title {
	
	public char int2char(int n)
	{
		char c = (char)(n+65);
		System.out.println(c);
		return c;
	}
	
	
	
	public String convertToTitle(int n) {
        String s="";
        
        while(n>0)
        {
        	s=int2char((n-1)%26)+s;
        	n=(n-(n-1)%26)/26;
        }
        	
        return s;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Num2Title n2t = new Num2Title();
		n2t.convertToTitle(26);
	}

}
