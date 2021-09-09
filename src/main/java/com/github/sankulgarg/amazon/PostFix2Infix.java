package com.github.sankulgarg.amazon;

import java.util.Stack;

public class PostFix2Infix {

    
static boolean isOperand(char x)
{
    return (x >= 'a' && x <= 'z') ||
            (x >= 'A' && x <= 'Z');
}
  
    
    //Function to evaluate a postfix expression.
    public static String postFix2Infix(String s)
    {
    
    	Stack<Integer> numbers= new Stack<>();
    StringBuilder inix=new StringBuilder();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='*' || s.charAt(i)=='/'||s.charAt(i)=='+' || s.charAt(i)=='-')
           {
        	   int num2=numbers.pop();
               int num1=numbers.pop();
        
               inix.append(num1).append(s.charAt(i)).append(num2);
           }
           else{
        	   numbers.push(s.charAt(i) -'0');
           }
            
        }
        
        return inix.toString();
        
        
    }
    public static void main(String[] args) {
		System.out.println(postFix2Infix("ab*c+"));
	}
}
