import java.util.Random;

/**
 * 实现二叉检索树
 * @author yangwenjing
 *
 */
public class BSearchTree {
	Leaf tree = null;
	
	public void create(int []a)
	{
		int i=0;
		
		
		while(i<a.length)
		{
			
			this.insert(a[i]);
			
			i++;
		}
		
		
	}
	
	public void insert(int x)
	{
		if(this.tree==null)
		{
			this.tree = new Leaf(x);
			return;
		}
		
		Leaf node = this.tree;
		boolean flag = false;
		while(true)
		{
		
			if(node.data<=x)
			{
				Leaf newNode = node.lLeaf;
				if(newNode==null)
				{
					newNode = new Leaf(x);
					node.lLeaf = newNode;
					break;
				}
				else{
					node = node.lLeaf;
				}
			}
			else{
				Leaf newNode = node.rLeaf;
				if(newNode==null)
				{
					newNode = new Leaf(x);
					node.rLeaf = newNode;
					break;
				}
				else{
					node = node.rLeaf;
				}
			}
		}
		
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
		bst.create(a);
		
		Leaf result = bst.search(10,bst.tree);
		if(result==null)
		{
			System.out.println("10不在检索树中");
		}
		else{
			System.out.println("10在检索树中");
		}

	}

}
