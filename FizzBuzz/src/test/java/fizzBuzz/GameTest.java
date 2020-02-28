package fizzBuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @DisplayName("Test Suite")
    @CsvSource({
        "'1',1",
        "'fizz',3",
        "'buzz',5",
        "'fizzbuzz',15",

    })
    void ptest(String word, int index){
        assertEquals(word, new Game(index).toString() );
    }
}
