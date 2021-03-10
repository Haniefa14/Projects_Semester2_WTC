package za.co.wethinkcode.fizzbuzz;

public class FizzBuzz {
    public static String checkNumber(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if ( divisibleBy3 && divisibleBy5 ) {
            return "FizzBuzz";
        } else if ( divisibleBy5) {
            return "Buzz";
        } else if ( divisibleBy3) {
            return "Fizz";
        } else {
            return String.valueOf(number);
        }
    }

    public static String countTo(int number) {
        String[] array = new String[number];
        for (int i = 1; i <= number; i++) {
            if (i == 1) {
                array[i-1] = "[" + checkNumber(i) + ", ";
            } else if (i == number) {
                array[i-1] = checkNumber(i) + "]";
            } else {
                array[i-1] = checkNumber(i) + ", ";
            }
        }
        StringBuilder list1 = new StringBuilder();
        for (String s: array) {
                list1.append(s);
            }
        return list1.toString();
    }
    public static void main(String[] args) {
        System.out.println(countTo(15));
    }
}
