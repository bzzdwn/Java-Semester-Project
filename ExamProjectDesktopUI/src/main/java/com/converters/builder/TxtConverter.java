package com.converters.builder;

import com.expressions.ExpressionsList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxtConverter implements IReadWriter {

    @Override
    public void Read(String file_name, ExpressionsList expressionsList) throws IOException {
        FileReader fileReader = new FileReader(file_name);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            if(tmp.contains("="))
                expressionsList.put(tmp.substring(0, tmp.indexOf("=")).trim());
            else
            expressionsList.put(tmp);
        }
    }

    @Override
    public void Write(String file_name, ExpressionsList expressionsList) throws IOException {
        FileWriter file_writer = new FileWriter(file_name);
        file_writer.write(expressionsList.toString());
        file_writer.close();
    }
}
