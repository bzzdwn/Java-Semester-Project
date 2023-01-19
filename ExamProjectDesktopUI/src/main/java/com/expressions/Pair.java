package com.expressions;

public class Pair<E> {
    private String expression;
    private E result;

    Pair(String key, E value){
        this.expression = key;
        this.result = value;
    }

    Pair(){
        expression = "";
        result = null;
    }

    public E getResult() {
        return result;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setResult(E result) {
        this.result = result;
    }
}
