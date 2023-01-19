import exam.project.converters.builder.TxtConverter;
import exam.project.expressions.ExpressionsList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TxtParseTests {
    @Test
    void read() throws IOException {
        TxtConverter txtConverter = new TxtConverter();
        ExpressionsList actual = new ExpressionsList();
        txtConverter.Read("examples\\input.txt", actual);
        String expected = "1+2 = 3.0\n" +
                "2+3+5*10 = 55.0\n" +
                "11+3*9*4/3 = 47.0\n" +
                "20-13+8*(12-3) = 79.0\n" +
                "3+2+1 = 6.0\n" +
                "3+3+5+10 = 21.0\n" +
                "1 + ( 1+1+1) + 1  = 5.0\n" +
                "9- 6 - 3  = 0.0\n" +
                "2-3-5-9  = -15.0\n" +
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
                "0/2/2 = 0.0\n" +
                "1+2  = 3.0\n";
        assertEquals(expected, actual.toString());
        }

}
