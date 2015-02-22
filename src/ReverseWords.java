
public class ReverseWords {
	
    public String reverseWords(String s) {
      s = s.trim();
      //System.out.println(s);
      String words[] = s.split("\\s+");
      String result = "";
      for(String str:words)
      {
    	  result = " "+str+result;
      }
     
    	
      return result.trim();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWords rw = new ReverseWords();
		rw.reverseWords("  the sky is     blue  ");
	}

}
