package leetcode;
public class isValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValid(TreeNode root, int left, int right) {
		if (root == null) {
			return true;
		}
		boolean isLeft, isRight;
		isLeft = isValid(root.left, left, root.val)
				&& (root.left == null || (root.left.val < root.val && root.left.val > left));
		isRight = isValid(root.right, root.val, right)
				&& (root.right == null || (root.right.val > root.val && root.right.val < right));
		return isLeft && isRight;
	}
}
