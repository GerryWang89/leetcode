package leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingRightPointer {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> buffer = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				TreeLinkNode node = queue.poll();
				node.next = queue.peek();
				if (node.left != null)
					buffer.offer(node.left);
				if (node.right != null)
					buffer.offer(node.right);
			}
			queue = new LinkedList<TreeLinkNode>(buffer);
			buffer.clear();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		
		new PopulatingRightPointer().connect(root);
	}

}
