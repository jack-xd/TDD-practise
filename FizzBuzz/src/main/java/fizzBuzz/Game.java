package fizzBuzz;

public class Game {

    private int myNumber;

    @Override
    public String toString() {
        if (myNumber%15 == 0) return "fizzbuzz";
        if (myNumber%3 == 0) return "fizz";
        if (myNumber%5 == 0) return "buzz";

        return String.valueOf(myNumber);
    }

    public Game( int rawNumber ) {
        this.myNumber = rawNumber;
    }


}
