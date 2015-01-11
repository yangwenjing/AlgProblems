import java.util.Random;

/**
 * 实现二叉检索树
 * @author yangwenjing
 *
 */
public class BSearchTree {
	
	
	public Leaf create(int []a)
	{
		int i=0;
		Leaf tree = null;
		
		while(i<a.length)
		{
			
			this.insert(tree, a[i]);
			
			i++;
		}
		
		return tree;
	}
	
	public void insert(Leaf tree, int x)
	{
		if(tree==null)
		{
			tree = new Leaf(x);
			//tree.data = x;
			tree.lLeaf=tree.rLeaf=null;
			return;
		}
		
		if(tree.data<=x)
		{
			insert(tree.lLeaf,x);
		}
		else
			insert(tree.rLeaf,x);
	}
	
	public Leaf search(int x, Leaf tree)
	{
		if(tree==null)return null;//没有
		if(tree.data==x)return tree;
		if(x>tree.data)
			return search(x,tree.rLeaf);
		else
			return search(x,tree.lLeaf);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSearchTree bst = new BSearchTree();
		int []a = new int[20];
		Random rng = new Random();
		for(int i=0;i<20;i++)
		{
			a[i]=rng.nextInt(20);
		}
		Leaf tree = bst.create(a);
		
		Leaf result = bst.search(10,tree);
		if(result==null)
		{
			System.out.println("10不在检索树中");
		}
		else{
			System.out.println("10在检索树中");
		}

	}

}
