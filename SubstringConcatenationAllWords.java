package LearnJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
*/

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int sumlen = words[0].length()*words.length;
        List<Integer> li= new ArrayList<Integer>();

        for(int i=0; i+sumlen<s.length(); i++){
        	if(isCaw(s.substring(i,i+sumlen+1))){
        		li.add(i);
        	}
        }
        return li;
    }
    
    boolean isCaw(String s, HashSet<String> hs){
    	if(hs.contains(s)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    HashSet<String> allWords(String[] words){
    	HashSet<String> hs = new HashSet<String>();
    	if(words.length == 0){
    		return hs;
    	}
    	else if(words.length == 1){
    		hs.add(words[0]);
    	}
    	else if(words.length == 2){
    		hs.add(words[0].concat(words[1]));
    		hs.add(words[1].concat(words[0]));
    	}
    	else if(words.length > 2){
    		hs.add(words[0].concat(words[1]));
    		hs.add(words[1].concat(words[0]));
    	}
    }
}
