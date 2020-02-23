package fizzBuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void should_print_normal_given_normal_number() {
        assertEquals("1", 1);
        assertEquals("2", 2);
    }

    @Test
    void should_print_fizz_given_number_divided_by_3() {
        assertEquals("fizz",3);
    }

    @Test
    void should_print_buzz_given_number_divided_by_5() {
        assertEquals("buzz",5);
    }

    @Test
    void should_print_fizzbuzz_given_number_divided_by_15() {
        assertEquals("fizzbuzz",15);
    }

    private void assertEquals( String s, int i ) {
        Assertions.assertEquals(s, new Game(i).toString());
    }
}
