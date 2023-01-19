package com.converters.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.expressions.ExpressionsList;

import java.io.*;

public class JsonConverter implements IReadWriter {
    @Override
    public void Read(String file_name, ExpressionsList expressionsList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        ExpressionsList read_receiver = objectMapper.readValue(new File(file_name), ExpressionsList.class);
        for (int i = 0; i < read_receiver.getExpressionList().size(); i++) {
            expressionsList.put(read_receiver.getExpressionList().get(i).getExpression());
        }
    }

    @Override
    public void Write(String file_name, ExpressionsList expressionsList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        FileOutputStream fileOutputStream = new FileOutputStream(file_name);
        objectMapper.writeValue(fileOutputStream, expressionsList);
    }
}
