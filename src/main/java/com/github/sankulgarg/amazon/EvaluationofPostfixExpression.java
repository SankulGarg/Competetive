package com.github.sankulgarg.amazon;

import java.util.Stack;

class EvaluationofPostfixExpression
{
    
    private static int calculate(int num1, int num2,char operation){
      
       switch (operation) {
	case '+':
		return num1 + num2;
		
    case '-':
        return num1 - num2;
        
    case '*':
        return num1 * num2;
        
    case '/':
        return num1 / num2;
        
	default:
		return 0;
	}
    
    }
    
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
    
    	Stack<Integer> numbers= new Stack<>();
    
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='*' || s.charAt(i)=='/'||s.charAt(i)=='+' || s.charAt(i)=='-')
           {
        	   int num2=numbers.pop();
               int num1=numbers.pop();
        
        
             
               numbers.push(calculate(num1,num2,s.charAt(i)));
           }
           else{
        	   numbers.push(s.charAt(i) -'0');
           }
            
        }
        
        return numbers.pop();
        
        
    }
public static void main(String[] args) {
	evaluatePostFix("231*+9-");
}
}