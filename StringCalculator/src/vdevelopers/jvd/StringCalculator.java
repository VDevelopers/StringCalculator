package vdevelopers.jvd;

public class StringCalculator {

    private final static String DEFAULT_DELIMITERS = ",|\n";
    private final static String PREFIX_NEW_DELIMITER = "//";

    public static int add(String numbers) {

        int result = 0;

        if (!numbers.isEmpty()) {

            String numbersWithoutOptionalDelimiters = getNumbersWithoutOptionalDelimiters(numbers);
            String regexDelimiter = getRegexDelimiter(numbers);
            String[] splitNumbers = numbersWithoutOptionalDelimiters.split(regexDelimiter);
            for (String number : splitNumbers) {
                result += Integer.valueOf(number);
            }
        }

        return result;
    }

    private static String getNumbersWithoutOptionalDelimiters(String numbers) {
        String numbersWithoutOptionalDelimiters = numbers;
        if (numbers.startsWith(PREFIX_NEW_DELIMITER)) {
            numbersWithoutOptionalDelimiters = numbers.substring(4);
        }
        return numbersWithoutOptionalDelimiters;
    }

    private static String getRegexDelimiter(String numbers) {
        String delimiter = DEFAULT_DELIMITERS;

        if (numbers.startsWith(PREFIX_NEW_DELIMITER)) {
            delimiter = numbers.substring(2, 3);
        }

        return delimiter;
    }
}
