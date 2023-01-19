package com.expressions;
import java.util.ArrayList;
import net.objecthunter.exp4j.*;
public class ExpressionsList {
    private ArrayList<Pair> expressionList;
    public ExpressionsList(){
        expressionList = new ArrayList<Pair>();
    }

    public void put(String value){
        Expression expression = new ExpressionBuilder(value).build();
        expressionList.add(new Pair(value, expression.evaluate()));
    }

    public ArrayList<Pair> getExpressionList() {
        return expressionList;
    }

    public String getExpression(int index){
        return expressionList.get(index).getExpression();
    }

    public double getResult(int index){
        return (double)expressionList.get(index).getResult();
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < expressionList.size(); i++) {
            result += expressionList.get(i).getExpression() +
                    " = " +
                    expressionList.get(i).getResult().toString() + "\n";
        }
        return result;
    }

    public int getSize(){
        return expressionList.size();
    }
}
