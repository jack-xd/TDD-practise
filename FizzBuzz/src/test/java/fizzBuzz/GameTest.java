package fizzBuzz;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;
import org.junit.Test;

public class GameTest {

    @Test
    public void should_print_raw_given_normal_number() {

        checkGameNumber("1", 1);
        checkGameNumber("2", 2);

    }

    @Test
    public void should_print_fizz_given_number_divisible_by_3() {

        checkGameNumber("fizz",3);
    }

    @Test
    public void should_print_buzz_given_number_divisible_by_5() {
        checkGameNumber("buzz",5);
    }

    @Test
    public void should_print_fizzbuzz_given_number_divisible_by_15() {
        checkGameNumber("fizzbuzz",15);
    }

    private void checkGameNumber( String s, int i ) {
        assertThat(new Game(i).toString(),is(s));
    }
}
