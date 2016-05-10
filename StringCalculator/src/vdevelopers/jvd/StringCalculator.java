package vdevelopers.jvd;

public class StringCalculator {

    public static int add(String numbers) {

        int result = 0;

        if (!numbers.isEmpty()) {
            String[] splitNumbers = numbers.split(",");
            for (String number : splitNumbers) {
                result += Integer.valueOf(number);
            }
        }

        return result;
    }
}
