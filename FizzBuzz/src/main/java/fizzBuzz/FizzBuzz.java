package fizzBuzz;

public final class FizzBuzz {

    public static String getStringByIndex(int index) {

        if (index%15 == 0) {
            return "FizzBuzz";
        } else if( index%3 == 0) {
            return "Fizz";
        } else if ( index%5 == 0 ) {
            return "Buzz";
        }else {
            return String.valueOf(index);
        }
    }

    public static void printAllString(int beginIndex, int endIndex) {

        for (int i = beginIndex; i<= endIndex; i++){
            System.out.println(getStringByIndex(i));
        }
    }

}
