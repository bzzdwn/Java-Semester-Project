package com.parser;

import java.util.Stack;

public class PostfixParser {
    private Stack<Double> stack;

    public double calculate(String input){
        stack = new Stack<Double>();
        char ch;
        double firstOperand;
        double secondOperand;
        double tempResult;

        for(int i=0;i<input.length();i++){
            ch = input.charAt(i);
            if(ch >= '0' && ch <= '9'){

                stack.push((double)ch - 48);
            }else{
                firstOperand = stack.peek();
                stack.pop();
                secondOperand = stack.peek();
                stack.pop();
                switch(ch){
                    case '+':
                        tempResult = firstOperand + secondOperand;
                        break;
                    case '-':
                        tempResult = secondOperand - firstOperand;
                        break;
                    case '*':
                        tempResult = firstOperand * secondOperand;
                        break;
                    case '/':
                        if (firstOperand == 0)
                            throw new IllegalArgumentException();
                        tempResult = secondOperand / firstOperand;
                        break;
                    default:
                        tempResult = 0;
                }
                stack.push(tempResult);
            }
        }
        double result = stack.peek();
        stack.pop();
        return result;
    }
}
