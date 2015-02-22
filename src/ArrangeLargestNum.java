import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/***
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 * @author yangwenjing
 *
 */
public class ArrangeLargestNum {
	
    public String largestNumber(int[] num) {
    	CharComparator comparator = new CharComparator();
    	List strArr = new LinkedList();
    	for(int i=0;i<num.length;i++)
    	{
    		strArr.add(num[i]+"");
    	}
        Collections.sort(strArr,comparator);
        String s="";
        for(int i=0;i<strArr.size();i++)
        {
        	
        	s+=strArr.get(i);
        	if(s.equals("0"))
        		return s;
        	
        }
        
        return s;
    }
	
	public class CharComparator implements Comparator<String>
	{
		
		public int compareSubStr(String arg0,String arg1)
		{
			int i=0;
			int len = arg0.length()<arg1.length()?arg0.length():arg1.length();
			
			while(i<len)
			{

				int x = Integer.parseInt(""+arg0.charAt(i));
				int y = Integer.parseInt(""+arg1.charAt(i));
				if(x>y)
				{
					return -1;
				}
				else if(x<y){
					return 1;
				}
				i++;
			}
			
			return 0;
		}

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			
			int len = arg0.length()<arg1.length()?arg0.length():arg1.length();
			int xi = arg0.length()/len;
			int yi = arg1.length()/len;
			int xleft = arg0.length()%len;
			int yleft = arg1.length()%len;
			
			int xprinter = 0, yprinter = 0;
			while(xprinter*len+len<=arg0.length()&&yprinter*len+len<=arg1.length())
			{
				String x = arg0.substring(xprinter*len,xprinter*len+len);
				String y = arg1.substring(yprinter*len,yprinter*len+len);
				int result  = this.compareSubStr(x, y);
				if(result!=0)return result;
				
				boolean flag = false;
				if(xprinter+1<xi)
				{
					xprinter++;
					flag=true;
				}
				if(yprinter+1<yi)
				{	
					yprinter++;
					flag=true;
				}
				if(!flag)
					break;
			}
			
			if(xleft==yleft&&xleft==0)
				return 0;
				
			String x = xleft==0?arg0:arg0.substring(xi*len,xi*len+xleft);
			String y = yleft==0?arg1:arg1.substring(yi*len,yi*len+yleft);
			
			
			return this.compare(x, y);
			
				
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {0,32,0};
		ArrangeLargestNum aln = new ArrangeLargestNum();
		String s = aln.largestNumber(num);
		System.out.println(s);
	}

}
