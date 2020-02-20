package fizzBuzz;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FizzBuzzTest {

    @Test
    public void should_print_1_given_index_1 (){

        Assert.assertThat(FizzBuzz.getStringByIndex(1),IsEqual.equalTo("1"));
    }

    @Test
    public void should_print_Fizz_given_index_3 () {
        Assert.assertThat(FizzBuzz.getStringByIndex(3),IsEqual.equalTo("Fizz"));
    }

    @Test
    public void should_print_Buzz_given_index_5 () {
        Assert.assertThat(FizzBuzz.getStringByIndex(5),IsEqual.equalTo(("Buzz")));
    }

    @Test
    public void should_print_FizzBuzz_given_index_15 () {
        Assert.assertThat(FizzBuzz.getStringByIndex(15),IsEqual.equalTo("FizzBuzz"));
    }

    @Test
    public void should_print_index_from_1_to_100 () {
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        System.setOut(new PrintStream(content));
        FizzBuzz.printAllString(1,100);
        String[] results = content.toString().split("\n");
        Assert.assertThat(results.length,IsEqual.equalTo(100));
    }
}
