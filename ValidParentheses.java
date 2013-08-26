package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ValidParentheses {

	public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('(',-3);
        map.put(')',3);
        map.put('{',-2);
        map.put('}',2);
        map.put('[',-1);
        map.put(']',1);
        List<Character> stack = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++){
            if( !stack.isEmpty() && map.get(s.charAt(i)) + map.get(stack.get(stack.size()-1)) == 0){
                stack.remove(stack.size()-1);
            }else{
                stack.add(s.charAt(i));
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()"));
	}

}
