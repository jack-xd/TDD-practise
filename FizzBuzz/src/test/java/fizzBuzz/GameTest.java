package fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    void should_print_number_given_normal_number() {
        assertEquals("1", new Game(1).toString() );
    }

    @Test
    void should_print_fizz_given_number_divided_by_3() {
        assertEquals("fizz", new Game(3).toString() );
    }

    @Test
    void should_print_buzz_given_number_divided_by_5() {
        assertEquals("buzz", new Game(5).toString() );
    }

    @Test
    void should_print_fizzbuzz_given_number_divided_by_15() {
        assertEquals("fizzbuzz", new Game(15).toString() );
    }
}
