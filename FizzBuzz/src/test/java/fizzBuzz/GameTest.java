package fizzBuzz;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    @Test
    public void should_print_number_given_normal_number() {
        testEquals(1, "1");
        testEquals(4, "4");

    }

    private void testEquals( int i, String s ) {
        Assert.assertThat(new Game(i).toString(), IsEqual.equalTo(s));
    }

    @Test
    public void should_print_fizz_given_number_divided_by_3() {

        testEquals(3,"fizz");
    }

    @Test
    public void should_print_fizzbuzz_given_number_divided_by_15() {
        testEquals(15,"fizzbuzz");
    }

    @Test
    public void should_print_buzz_given_number_divided_by_5() {
        testEquals(5,"buzz");
    }
}
