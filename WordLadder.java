package leetcode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		int step = 0;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		for (int i = 0; !queue.isEmpty(); i++) {
			Queue<String> buffer = new LinkedList<String>();
			while (!queue.isEmpty()) {
				String cur = queue.poll();
				if (cur.equals(end)) {
					return i+1;
				}
				buffer.addAll(getNext(cur, dict));
			}
			queue = buffer;
		}
		return step;
	}

	private LinkedList<String> getNext(String cur, HashSet<String> dict) {
		LinkedList<String> ret = new LinkedList<String>();
		for(int i = 0; i < cur.length(); i++){
			for(int j = 0; j <= 'z'-'a'; j++){
				String tmp = cur.substring(0, i) + (char)('a'+j) + cur.substring(i+1);
				if(dict.contains(tmp)){
					ret.add(tmp);
				}
			}
		}
		dict.removeAll(ret);
		return ret;
	}

	private boolean isReachable(String s, String dest) {
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != dest.charAt(i)) {
				diff++;
			}
		}
		return diff == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		new WordLadder().ladderLength("a", "c", dict);
	}
}
