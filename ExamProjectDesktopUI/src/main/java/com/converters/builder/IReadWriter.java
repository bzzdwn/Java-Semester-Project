package com.converters.builder;

import com.expressions.ExpressionsList;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface IReadWriter {
    void Read(String file_name, ExpressionsList expressionsList) throws IOException, XMLStreamException;

    void Write(String file_name, ExpressionsList expressionsList) throws IOException, XMLStreamException;
}
