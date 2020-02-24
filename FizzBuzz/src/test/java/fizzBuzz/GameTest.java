package fizzBuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void should_print_normal_given_normal_number() {
        testEquals("1", 1);
        testEquals("2", 2);
    }

    @Test
    void should_print_fizz_given_number_divided_by_3() {
        testEquals("fizz",3);
    }

    @Test
    void should_print_buzz_given_number_divided_by_5() {
        testEquals("buzz",5);
    }

    @Test
    void should_print_fizzbuzz_given_number_divided_by15() {
        testEquals("fizzbuzz",15);
    }

    private void testEquals( String s, int i ) {
        Assertions.assertEquals(s, new Game(i).toString());
    }
}
