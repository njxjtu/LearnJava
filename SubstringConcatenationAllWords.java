package LearnJava;

import java.util.ArrayList;
import java.util.Arrays;
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
Expected Output: []

Example 2:
"wordgoodgoodgoodbestword"
["word","good","best","good"]
Expected output: [8]

Example 3:
""
[]

Example 4:
"pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel"
["dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"]
*/

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring1(String s, String[] words) {
    	List<Integer> li= new ArrayList<Integer>();
    	if(s.length()==0 || words.length==0){
    		return li;
    	}
        int sumlen = words[0].length()*words.length;

        

        for(int i=0; i+sumlen<s.length()+1; i++){
        	if(isCaw(s.substring(i,i+sumlen), allWords(words))){
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
    	else if(words.length >= 2){
    		for(int i=0; i<words.length; i++){
    			String[] tempw = new String[words.length-1];
    			for(int j=0; j<words.length-1; j++){
    				if(j<i){
    					tempw[j] = words[j];
    				}
    				else if(j==i){
    					tempw[j] = words[j+1];
    				}
    				else if(j>i){
    					tempw[j] = words[j+1];
    				}
    			}
    			for(String str : allWords(tempw)){
    				hs.add(words[i].concat(str));
    			}
    		}
    	}
    	return hs;
    }
    
    
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> li= new ArrayList<Integer>();
    	if(s.length()==0 || words.length==0){
    		return li;
    	}
    	Arrays.sort(words);
    	for(int i=0; i<words.length; i++){
    		System.out.println("words[i]: "+words[i]);
    	}
    	int sumlen = words[0].length()*words.length;
    	String[] sarr = new String[words.length];
    	for(int i=0; i<s.length() && i+sumlen-1 < s.length(); i++){
    		for(int j=0; j<words.length; j++){
    			sarr[j] = s.substring(i+j*words[0].length(), i+(j+1)*words[0].length());
    		}
    		Arrays.sort(sarr);
    		for(int k=0; k<sarr.length; k++){
        		System.out.println("sarr[k]: "+sarr[k]);
        	}
    		if(Arrays.equals(words, sarr)){
    			System.out.println("Equal ");
    			li.add(i);
    		}
    	}
        return li;
    }
    
    
    public static void main(String[] args){
    	SubstringConcatenationAllWords obj = new SubstringConcatenationAllWords();
    	String s = "wordgoodgoodgoodbestword";
    	String[] words = {"word","good","best","word"};
    	List<Integer> intList = obj.findSubstring(s, words);
    	for(int k : intList){
    		System.out.print(k);
    		System.out.print(", ");
    	}

    }
}
