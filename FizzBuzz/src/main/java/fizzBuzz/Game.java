package fizzBuzz;

public class Game {
    private int index;

    public Game( int index ) {
        this.index = index;
    }

    @Override
    public String toString() {
        if(index%15==0) return "fizzbuzz";
        if(index%3==0) return "fizz";
        if(index%5==0) return "buzz";
        return String.valueOf(index);
    }
}
