package LearnJava;
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input:
s = "acdcb"
p = "a*c?b"
Output: false

Example 6:
Input:
s = "a"
p = "a*"
Output = true

Example 7:
Input:
s = "mississippi"
p = "m??*ss*?i*pi"
Output = false

Example 8:
s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
p = "a*******b"
false
Example 9:
"babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"
"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
    	boolean[][] tab = new boolean[s.length()][p.length()];
    	return tab[s.length()-1][p.length()-1];
        
    }
    
    public static void main(String[] args){
    	WildcardMatching obj = new WildcardMatching();
    	/*System.out.println(obj.isMatch("aa", "a")); //false
    	System.out.println(obj.isMatch("aa", "*")); //true
    	System.out.println(obj.isMatch("cb", "?a")); //false
    	System.out.println(obj.isMatch("adceb", "*a*b")); //true
    	System.out.println(obj.isMatch("acdcb", "a*c?b")); //false
    	System.out.println(obj.isMatch("mississippi", "m??*ss*?i*pi")); //false
    	System.out.println(obj.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b")); //false
*/    	System.out.println(obj.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a")); //
    	}
}
