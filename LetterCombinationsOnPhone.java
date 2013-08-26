package leetcode;
import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOnPhone {
	String[] letters = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> list = new ArrayList<String>();
        if(digits == null || digits.equals("")){
            list.add("");
            return list;
        }
        if(digits.length() == 1){
            for(int i = 0; i < letters[digits.charAt(0)-'0'].length(); i++){
        		list.add(letters[digits.charAt(0)-'0'].charAt(i)+"");
        	}
        	return list;
        }
		ArrayList<String> suffix = letterCombinations(digits.substring(1));
		for(int i = 0; i < letters[digits.charAt(0)-'0'].length(); i++){
			for(int j = 0; j < suffix.size(); j++){
				list.add(letters[digits.charAt(0)-'0'].charAt(i)+suffix.get(j));
			}
    	}
        return list;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> sl = new LetterCombinationsOnPhone().letterCombinations("");
//		for(String item:sl){
//			System.out.println(item);
//		}
	}

}
