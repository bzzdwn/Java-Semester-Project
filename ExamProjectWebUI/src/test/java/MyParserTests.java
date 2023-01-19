import exam.project.parser.PostfixConverter;
import exam.project.parser.PostfixParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyParserTests {
    PostfixConverter postfixConverter = new PostfixConverter();
    PostfixParser postfixParser = new PostfixParser();
    @Test
    void SummaryTest1(){
        assertEquals(6,
                postfixParser.calculate(postfixConverter.convert("3 + 2 + 1")));
    }
    @Test
    void SummaryTest2(){
        assertEquals(12,
                postfixParser.calculate(postfixConverter.convert("3 +3 + 5+1")));
    }
    @Test
    void SummaryTest3(){
        assertEquals(5,
                postfixParser.calculate(postfixConverter.convert("1 + ( 1+1+1) + 1")));
    }
    @Test
    void ResidualTest1(){
        assertEquals(0,
                postfixParser.calculate(postfixConverter.convert("9- 6 - 3")));
    }
    @Test
    void ResidualTest2(){
        assertEquals(-15,
                postfixParser.calculate(postfixConverter.convert("2-3-5-9")));
    }
    @Test
    void ResidualTest3(){
        assertEquals(-5,
                postfixParser.calculate(postfixConverter.convert("9 - 5 - 9")));
    }
    @Test
    void SummaryResidualTest1(){
        assertEquals(8,
                postfixParser.calculate(postfixConverter.convert("3 + 5- 7 + 9 - 2")));
    }
    @Test
    void SummaryResidualTest2(){
        assertEquals(-2,
                postfixParser.calculate(postfixConverter.convert("1 + 1 - 1 + 1 - 1 - 1 - 1 - 1")));
    }
    @Test
    void MultiplicationTest1(){
        assertEquals(6,
                postfixParser.calculate(postfixConverter.convert("3 * 2 * 1")));
    }
    @Test
    void MultiplicationTest2(){
        assertEquals(729,
                postfixParser.calculate(postfixConverter.convert("9 * 9 * 9")));
    }
    @Test
    void MultiplicationTest3(){
        assertEquals(0,
                postfixParser.calculate(postfixConverter.convert("9 * 9 * 9 * 0")));
    }
    @Test
    void MultiplicationTest4(){
        assertEquals(-3,
                postfixParser.calculate(postfixConverter.convert("3 - 3 * 2")));
    }
    @Test
    void MultiplicationTest5(){
        assertEquals(0,
                postfixParser.calculate(postfixConverter.convert("(3 - 3) * 2")));
    }
    @Test
    void MultiplicationTest6(){
        assertEquals(-3,
                postfixParser.calculate(postfixConverter.convert("(1 + 2) * (1 - 2)")));
    }
    @Test
    void DivisionTest1(){
        assertEquals(3,
                postfixParser.calculate(postfixConverter.convert("6 / 2")));
    }
    @Test
    void DivisionTest2(){
        assertEquals(1.5,
                postfixParser.calculate(postfixConverter.convert("6 / 2 / 2")));
    }
    @Test
    void DivisionTest3(){
        assertEquals(0,
                postfixParser.calculate(postfixConverter.convert("0 / 2 / 2")));
    }
    @Test
    void DivisionByZeroTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> postfixParser.calculate(postfixConverter.convert("2 / 0")));
    }
}
