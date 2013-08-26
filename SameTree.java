package leetcode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
    
    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == null && q == null;
        boolean left = isSame(p.left,q.left);
        boolean val = p.val == q.val;
        boolean right = isSame(p.right,q.right);
        return left && val && right;
    }
}
