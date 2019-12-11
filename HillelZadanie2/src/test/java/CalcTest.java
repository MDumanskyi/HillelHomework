import calc.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalcTest {
@Test
    public void summTest(){
        Calculator c = new Calculator();
        int res = c.summ(5,6);
        Assert.assertEquals(11, res);
    }
    @Test
   public void subtTest(){
        Calculator q = new Calculator();
        int res = q.subt(8,6);
        Assert.assertEquals(2, res);
    }
    @Test
    public void multTest(){
        Calculator w = new Calculator();
        int res = w.mult(5,6);
        Assert.assertEquals(30, res);
    }
    @Test
    public void divTest(){
        Calculator t = new Calculator();
        int res = t.div(21,5);
        Assert.assertEquals(4, res);
    }
}
