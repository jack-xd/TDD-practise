package fizzBuzz;

public class Game {
    private int number;

    public Game( int number ) {
        this.number = number;
    }

    @Override
    public String toString() {
        if(number%15==0) return "fizzbuzz";
        if(number%3==0) return "fizz";
        if(number%5==0) return "buzz";
        return String.valueOf(number);
    }
}
