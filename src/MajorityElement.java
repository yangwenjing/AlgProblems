import java.util.LinkedList;
import java.util.List;


public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,3,4};
		testLinkedList(arr);
		MajorityElement me = new MajorityElement();
		int result = me.majorityElement(arr);
		System.out.println(result);
	}

	public static void testLinkedList(int []num)
	{
		List<Integer>list = new LinkedList<Integer>();
		for(int i=0;i<num.length;i++)
		{
			int index = list.indexOf(num[i]);
			list.add(index+1,num[i]);
		}
		
		for(int x:list)
		{
			System.out.println(x);
		}
		
	}

	public int majorityElement(int[] num) {
		List<Integer>list = new LinkedList<Integer>();
		for(int i=0;i<num.length;i++)
		{
			int index = list.indexOf(num[i]);
			list.add(index+1,num[i]);
		}
		
		int counter=0;
		int temp=0;
		for(int x:list)
		{
			if(counter==0)
				temp=x;
			if(temp==x)
			{
				counter++;
			}else{
				counter=1;
				temp=x;
			}
			
			if(counter>Math.floor(num.length/2))
			{
				return temp;
			}
		}
		return 0;
    }

}
