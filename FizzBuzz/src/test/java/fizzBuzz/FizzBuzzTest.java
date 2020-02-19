package fizzBuzz;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;

public class FizzBuzzTest {

    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;
    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Before
    public void setUp() {

        bytes = new ByteArrayOutputStream();//把标准输出指定到ByteArrayOutputStream中
        console = System.out;// 获取System.out 输出流的句柄
        System.setOut(new PrintStream(bytes));//将原本输出到控制台Console的字符流重定向到bytes
        fizzBuzz.printFizzBuzz();
    }

    @After
    public void tearDown() {
        System.setOut(console);
    }

    @Test
    public void should_print_1() {
        assertThat(bytes.toString(), containsString("1"));
    }

    @Test
    public void should_print_fizz() {
        assertThat(bytes.toString(), containsString("Fizz"));
    }

    @Test
    public void should_print_Buzz() {
        assertThat(bytes.toString(), containsString("Buzz"));
    }

    @Test
    public void should_print_FizzBuzz() {
        assertThat(bytes.toString(), containsString("FizzBuzz"));
    }

}
