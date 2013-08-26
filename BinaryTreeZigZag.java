package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeZigZag {

	private ArrayList<ArrayList<Integer>> ret;
	private boolean leftToRight;
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		leftToRight = true;
        ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	queue = getElementsOfALevel(queue);
        	leftToRight = !leftToRight;
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
		if(!leftToRight){
			ArrayList<Integer> reverseList = new ArrayList<Integer>();
			for(int i = 0; i < appendList.size(); i++){
				reverseList.add(appendList.get(appendList.size()-1-i));
			}
			appendList = reverseList;
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
