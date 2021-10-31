package com.aj.string.palindrome;

/**
 * Leetcode: 14
 * @author ajay
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {

		String [] strs = {"flower","flow","flight"};
//		System.out.println(longestCommonPrefix(strs));
//		System.out.println(longestCommonPrefix1(strs));
		System.out.println(longestCommonPrefix2(strs));
	}
	
	// brute force
	public static String longestCommonPrefix(String[] strs) {
		var str = "";
		
		if(null == strs || strs.length <= 0) {
			return str;
		}
		else {
			str = strs[0];
			
			for(var i = 1; i<strs.length;i++) {
				
				if(str.length()>=strs[i].length()) {
					
					str = extracted(str, strs[i]);
				}
				else {
					str = extracted(strs[i], str);
				}
			}
		}
		return str;
    }

	private static String extracted(String lengthyStr, String shortStr) {
		
		var retValue = "";
		for(var j=0;j<shortStr.length();j++) {
			if(shortStr.charAt(j) != lengthyStr.charAt(j)) {
				return retValue;
			}
			else {
				retValue += shortStr.charAt(j);
			}
		}
		return retValue;
	}



	//Solution: 2 (Horizontal Scanning)
	public static String longestCommonPrefix1(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	//Solution 3 (vertical scanning)
	public static String longestCommonPrefix2(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
}
