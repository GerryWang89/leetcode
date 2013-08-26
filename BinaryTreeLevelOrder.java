package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrder {
	private ArrayList<ArrayList<Integer>> ret;
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	queue = getElementsOfALevel(queue);
        }
        return ret;
    }
	
	private Queue<TreeNode> getElementsOfALevel(Queue<TreeNode> queue){
		Queue<TreeNode> ret = new LinkedList<TreeNode>();
		ArrayList<Integer> appendList = new ArrayList<Integer>();
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			appendList.add(node.val);
			if(node.left != null){
				ret.offer(node.left);
			}
			if(node.right != null){
				ret.offer(node.right);
			}
		}
		this.ret.add(appendList);
		return ret;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
