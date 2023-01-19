package com.converters.builder;


import com.expressions.ExpressionsList;

import java.io.*;

import javax.xml.stream.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLConverter implements IReadWriter{

    @Override
    public void Read(String file_name, ExpressionsList expressionsList) throws IOException, XMLStreamException {
        boolean isExpression = false;
        boolean reiterations = false;
        boolean wflag = false;
        boolean rflag = false;
        String key = "";
        int value = 0;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(file_name));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("expressionList")) {
                        } else if (qName.equalsIgnoreCase("expression")) {
                            isExpression = true;
                        }
                        /*else if (qName.equalsIgnoreCase("reiterations")) {
                            reiterations = true;
                        }*/
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (isExpression) {
                            expressionsList.put(characters.getData().trim());
                            isExpression = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equalsIgnoreCase("expression")) {
                        }
                        break;

                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(XMLStreamException e){
            e.printStackTrace();
        }
    }

    @Override
    public void Write(String file_name, ExpressionsList expressionsList) throws IOException, XMLStreamException {
        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeCharacters("\n\t");
            xMLStreamWriter.writeStartElement("expressionsList");
            for (int i = 0; i < expressionsList.getSize(); i++) {
                xMLStreamWriter.writeCharacters("\n\t\t");
                String expression = expressionsList.getExpression(i);
                double result = expressionsList.getResult(i);
                xMLStreamWriter.writeStartElement("expression");
                xMLStreamWriter.writeCharacters("\n\t\t\t");
                xMLStreamWriter.writeCharacters(expression);
                xMLStreamWriter.writeCharacters("\n\t\t\t");
                xMLStreamWriter.writeStartElement("result");
                xMLStreamWriter.writeCharacters("\n\t\t\t\t");
                xMLStreamWriter.writeCharacters(String.valueOf(result));
                xMLStreamWriter.writeCharacters("\n\t\t\t");
                xMLStreamWriter.writeEndElement();
                xMLStreamWriter.writeCharacters("\n\t\t");
                xMLStreamWriter.writeEndElement();
            }
            xMLStreamWriter.writeCharacters("\n\t");
            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();

            stringWriter.close();

            FileWriter fileWriter = new FileWriter(file_name);
            fileWriter.write(xmlString);
            fileWriter.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
