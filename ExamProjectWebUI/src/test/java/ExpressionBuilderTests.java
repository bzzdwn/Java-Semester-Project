import net.objecthunter.exp4j.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionBuilderTests {
    @Test
    void SummaryTest1(){
        Expression expression = new ExpressionBuilder("3 + 2 + 1").build();
        Assertions.assertEquals(6, expression.evaluate());
    }
    @Test
    void SummaryTest2(){
        Expression expression = new ExpressionBuilder("3 +3 + 5+10").build();
        Assertions.assertEquals(21, expression.evaluate());
    }
    @Test
    void SummaryTest3(){
        Expression expression = new ExpressionBuilder("1 + ( 1+1+1) + 1").build();
        Assertions.assertEquals(5, expression.evaluate());
    }
    @Test
    void ResidualTest1(){
        Expression expression = new ExpressionBuilder("9- 6 - 3").build();
        Assertions.assertEquals(0, expression.evaluate());
    }
    @Test
    void ResidualTest2(){
        Expression expression = new ExpressionBuilder("2-3-5-9").build();
        Assertions.assertEquals(-15, expression.evaluate());
    }
    @Test
    void ResidualTest3(){
        Expression expression = new ExpressionBuilder("9 - 5 - 9").build();
        Assertions.assertEquals(-5, expression.evaluate());
    }
    @Test
    void SummaryResidualTest1(){
        Expression expression = new ExpressionBuilder("3 + 5- 7 + 9 - 2").build();
        Assertions.assertEquals(8, expression.evaluate());
    }
    @Test
    void SummaryResidualTest2(){
        Expression expression = new ExpressionBuilder("1 + 1 - 1 + 1 - 1 - 1 - 1 - 1").build();
        Assertions.assertEquals(-2, expression.evaluate());
    }
    @Test
    void MultiplicationTest1(){
        Expression expression = new ExpressionBuilder("3 * 2 * 1").build();
        Assertions.assertEquals(6, expression.evaluate());
    }
    @Test
    void MultiplicationTest2(){
        Expression expression = new ExpressionBuilder("9 * 9 * 9").build();
        Assertions.assertEquals(729, expression.evaluate());
    }
    @Test
    void MultiplicationTest3(){
        Expression expression = new ExpressionBuilder("9 * 9 * 9 * 0").build();
        Assertions.assertEquals(0, expression.evaluate());
    }
    @Test
    void MultiplicationTest4(){
        Expression expression = new ExpressionBuilder("3 - 3 * 2").build();
        Assertions.assertEquals(-3, expression.evaluate());
    }
    @Test
    void MultiplicationTest5(){
        Expression expression = new ExpressionBuilder("(3 - 3) * 2").build();
        Assertions.assertEquals(0, expression.evaluate());
    }
    @Test
    void MultiplicationTest6(){
        Expression expression = new ExpressionBuilder("(1 + 2) * (1 - 2)").build();
        Assertions.assertEquals(-3, expression.evaluate());
    }
    @Test
    void DivisionTest1(){
        Expression expression = new ExpressionBuilder("6 / 2").build();
        Assertions.assertEquals(3, expression.evaluate());
    }
    @Test
    void DivisionTest2(){
        Expression expression = new ExpressionBuilder("6 / 2 / 2").build();
        Assertions.assertEquals(1.5, expression.evaluate());
    }
    @Test
    void DivisionTest3(){
        Expression expression = new ExpressionBuilder("0 / 2 / 2").build();
        Assertions.assertEquals(0, expression.evaluate());
    }
    @Test
    void DivisionTest4(){
        Expression expression = new ExpressionBuilder("2 / 2 / 0").build();
        Assertions.assertThrows(ArithmeticException.class, () -> expression.evaluate());
    }
}
