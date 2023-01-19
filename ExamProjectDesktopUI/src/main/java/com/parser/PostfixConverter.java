package com.parser;

import java.util.Stack;

public class PostfixConverter {
    private Stack<Character> stack;
    private String result = "";
    public PostfixConverter() {
    }

    public String convert(String input){
        input = input.replaceAll("\\s+","");
        stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch){
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParenthesis(ch);
                    break;
                default:
                    result = result+ch;
                    break;
            }
        }

        while(!stack.isEmpty()){
            result = result + (char)(stack.pop());
        }

        return result;
    }

    private void gotOperator(char operator, int precedence){
        while(!stack.isEmpty()){
            char prevOperator = (char)(stack.pop());
            if(prevOperator == '('){
                stack.push(prevOperator);
                break;
            }else{
                int precedence1;
                if(prevOperator == '+' || prevOperator == '-'){
                    precedence1 = 1;
                }else{
                    precedence1 = 2;
                }

                if(precedence1 < precedence){
                    stack.push(prevOperator);
                    break;
                }else{
                    result = result + prevOperator;
                }
            }
        }
        stack.push(operator);
    }

    private void gotParenthesis(char parenthesis){
        while(!stack.isEmpty()){
            char ch = (char)stack.pop();
            if(ch == '('){
                break;
            }else{
                result = result + ch;
            }
        }
    }
}