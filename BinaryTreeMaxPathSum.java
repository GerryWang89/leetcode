package leetcode;

public class BinaryTreeMaxPathSum {
	public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return maxSingle(root.left) + maxSingle(root.right) + root.val;
    }
    
    public int maxSingle(TreeNode root){
        if(root == null){
            return 0;
        }
        int subVal = Math.max(maxSingle(root.left),maxSingle(root.right));
        int ret = root.val + (subVal>0?subVal:0);
        return ret>0?ret:0;
    }
    
    public static void main(String[] args){
    	TreeNode node = new TreeNode(2);
    	node.right = new TreeNode(-1);
    	System.out.println(new BinaryTreeMaxPathSum().maxPathSum(node));
    }
}
