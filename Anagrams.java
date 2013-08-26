package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		String[] key = new String[strs.length];
		for (int i = 0; i < strs.length; i++) {
			char[] chars = new char[strs[i].length()];
			for (int j = 0; j < chars.length; j++) {
				chars[j] = strs[i].charAt(j);
			}
			Arrays.sort(chars);
			String temp = new String(chars);
			key[i] = temp;
			if (hash.containsKey(temp)) {
				hash.put(temp, hash.get(temp) + 1);
			} else {
				hash.put(temp, 1);
			}
		}
		for (int i = 0; i < key.length; i++) {
			if (hash.get(key[i]) > 1) {
				ret.add(strs[i]);
			}
		}
		return ret;
	}

	private boolean isAnagrams(String s1, String s2) {
		if (s1.equals("") && s2.equals("")) {
			return true;
		}
		String[] sa1 = s1.split("");
		String[] sa2 = s2.split("");
		Arrays.sort(sa1);
		Arrays.sort(sa2);
		int i = 0;
		for (i = 0; i < sa1.length && i < sa2.length; i++) {
			if (!sa1[i].equals(sa2[i])) {
				return false;
			}
		}
		if (i == sa1.length && i == sa2.length)
			return true;
		else
			return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Anagrams().isAnagrams("c", "c");
	}

}
