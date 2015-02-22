import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class DNASearch {
	
	public static Hashtable Bit2CharHt = new Hashtable();
    
	//需要用位操作处理
    public List<String> findRepeatedDnaSequences(String s) {
        List arr = new ArrayList();
        
        if(s.length()<11)return arr;
    
        //
        Bit2CharHt.put(0,'A');
        Bit2CharHt.put(1,'C');
        Bit2CharHt.put(2,'T');
        Bit2CharHt.put(3,'G');
        
        
        
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        int i=0;
        int bits=0;
        while(i<9)
        {
        	bits = push(bits,s.charAt(i));
        	
        	i++;
        }
        
        while(i<s.length())
        {
        	bits = push(bits,s.charAt(i));
        	//System.out.println(Integer.toBinaryString(bits));
        	if(ht.containsKey(bits))
        	{
        		int num = ht.get(bits);
        		
        		ht.put(bits, num+1);
        	
        	}else{
        		ht.put(bits, 1);
        	}
        	
        	i++;
        }
        
        for(int key:ht.keySet())
        {
        	if(ht.get(key)>1)
        	{
        		//处理成字符
        		String subStr = pop(key);
        		arr.add(subStr);
        		
        	}
        }
        
    	return arr;
    }
    
    public static int mask = (1<<20)-1;
    
    public int push(int bits, char s)
    {
    	bits<<=2;
    	bits+=(s>>1&0x3);
    	
    	bits&=mask;
    	return bits;
    }
    
    
    
    public String pop(int bits)
    {
    	//System.out.println("转换bits--"+bits);
    	int i=20;
    	int mask2bits = 0x3;
    	String s = "";
    	while(i>0)
    	{
    		int key = bits&mask2bits;
    		s = Bit2CharHt.get(key)+s;
    		
    		//System.out.println(s);
    		
    		i-=2;
    		bits>>=2;
    	}
    	return s;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DNASearch ds = new DNASearch();
		
//		int bits = (1<<21)-1;
//		System.out.println(Integer.toBinaryString(bits));
//		int abits = ('A'>>1&0x3);
//		System.out.println(Integer.toBinaryString(abits));	
//		abits = ('G'>>1&0x3);
//		System.out.println(Integer.toBinaryString(abits));	
//		abits = ('C'>>1&0x3);
//		System.out.println(Integer.toBinaryString(abits));	
//		abits = ('T'>>1&0x3);
//		System.out.println(Integer.toBinaryString(abits));	
//		
//		int result = ds.push(bits, 'A');
//		
//		System.out.println(Integer.toBinaryString(result));
		String s = "AAAAACCCCCAAAAACCCCCCAAAAA";
		List arr = ds.findRepeatedDnaSequences(s);
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
	}

}
