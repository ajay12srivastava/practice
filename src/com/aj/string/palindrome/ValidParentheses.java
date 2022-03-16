package com.aj.string.palindrome;

import java.util.Stack;

/**
 * 20. Valid Parentheses (LeetCode)
 * @author ajay
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		
		System.out.println(isValid("([}}])"));

	}
	
	public static boolean isValid(String s) {
		
        if(s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            if(ch == '(' || ch == '{' || ch == '[' )
                stack.push(ch);
            else if(!stack.isEmpty() && ch == ')' && stack.peek() == '(')
                stack.pop();
            else if(!stack.isEmpty() && ch == '}' && stack.peek() == '{')
                stack.pop();
            else if(!stack.isEmpty() && ch == ']' && stack.peek() == '[')
                stack.pop();
            else return false;
        } 
        return stack.isEmpty();
    }
}
