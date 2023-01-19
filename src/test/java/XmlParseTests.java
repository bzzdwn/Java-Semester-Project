import exam.project.converters.builder.TxtConverter;
import exam.project.converters.builder.XMLConverter;
import exam.project.expressions.ExpressionsList;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlParseTests {
    @Test
    void read() throws IOException, XMLStreamException {
        XMLConverter xmlConverter = new XMLConverter();
        ExpressionsList actual = new ExpressionsList();
        xmlConverter.Read("examples\\input.xml", actual);
        String expected = "2+3+5*10 = 55.0\n" +
                "11+3*9*4/3 = 47.0\n" +
                "20-13+8*(12-3) = 79.0\n" +
                "3+2+1 = 6.0\n" +
                "3+3+5+10 = 21.0\n" +
                "1 + ( 1+1+1) + 1 = 5.0\n" +
                "9- 6 - 3 = 0.0\n" +
                "2-3-5-9 = -15.0\n" +
                "9 - 5 - 9 = -5.0\n" +
                "3 + 5- 7 + 9 - 2 = 8.0\n" +
                "1+1-1+1-1-1-1-1 = -2.0\n" +
                "3*2*1 = 6.0\n" +
                "9*9*9 = 729.0\n" +
                "9*9*9*0 = 0.0\n" +
                "3-3*2 = -3.0\n" +
                "(3-3)*2 = 0.0\n" +
                "(1+2)*(1-2) = -3.0\n" +
                "6/2 = 3.0\n" +
                "6/2/2 = 1.5\n" +
                "0/2/2 = 0.0\n";
        assertEquals(expected, actual.toString());
    }
    @Test
    void write() throws IOException, XMLStreamException {
        File expected = new File("input_result.xml");
        XMLConverter xmlConverter = new XMLConverter();
        ExpressionsList list = new ExpressionsList();
        String[] expected_expressions = {"1+2\n",
                "2+3+5*10",
                "11+3*9*4/3",
                "20-13+8*(12-3)",
                "3+2+1",
                "3+3+5+10",
                "1 + ( 1+1+1) + 1",
                "9- 6 - 3",
                "2-3-5-9",
                "9 - 5 - 9",
                "3 + 5- 7 + 9 - 2",
                "1+1-1+1-1-1-1-1",
                "3*2*1",
                "9*9*9",
                "9*9*9*0",
                "3-3*2",
                "(3-3)*2",
                "(1+2)*(1-2)",
                "6/2",
                "6/2/2",
                "0/2/2",
                "1+2"};
        for (int i = 0; i < expected_expressions.length; i++) {
            list.put(expected_expressions[i]);
        }
        xmlConverter.Write("input_result.xml", list);
        assertEquals(expected, new File("input_result.xml"));
    }
}
