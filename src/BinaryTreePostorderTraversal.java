import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 */

public class BinaryTreePostorderTraversal {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      }

	public List<Integer> postorderTraversal(TreeNode root) {
	
		
		List<TreeNode>stack = new ArrayList<TreeNode>();
		List<Integer>result = new ArrayList<Integer>();
		
		if(root==null)return result;
		
		stack.add(root);
		
		while(!stack.isEmpty())
		{
			TreeNode s = stack.get(0);
			stack.remove(0);
			if(null!=s.left)
			{
				stack.add(0,s.left);
			}
			
			if(null!=s.right){
				stack.add(0,s.right);
			}
			result.add(0, s.val);
			
		}
		
		
		return result;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();
		
		btpt.postorderTraversal(root);

	}

}
