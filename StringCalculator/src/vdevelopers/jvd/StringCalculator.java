package vdevelopers.jvd;

import vdevelopers.jvd.exceptions.NegativesNotAllowedException;

public class StringCalculator {

    private final static String DEFAULT_DELIMITERS = ",|\n";
    private final static String PREFIX_NEW_DELIMITER = "//";
    private final static String PREFIX_NEGATIVE = "-";
    private final static String END_NEW_DELIMITER = "\n";

    public static int add(String numbers) throws NegativesNotAllowedException {

        int result = 0;

        if (!numbers.isEmpty()) {

            String numbersWithoutOptionalDelimiters = getNumbersWithoutOptionalDelimiters(numbers);
            String regexDelimiter = getRegexDelimiter(numbers);
            String[] splitNumbers = numbersWithoutOptionalDelimiters.split(regexDelimiter);
            for (String number : splitNumbers) {
                if (number.startsWith(PREFIX_NEGATIVE)) {
                    throw new NegativesNotAllowedException(getErrorNegativeMessage(splitNumbers));
                }

                int value = Integer.valueOf(number);
                if (value < 1000) {
                    result += value;
                }
            }
        }

        return result;
    }

    private static String getErrorNegativeMessage(String[] splitNumbers) {
        StringBuffer message = new StringBuffer();
        for (String number : splitNumbers) {
            if (number.startsWith(PREFIX_NEGATIVE)) {
                if (message.toString().isEmpty()) {
                    message.append(number);
                } else {
                    message.append(",");
                    message.append(number);
                }
            }
        }
        return "ERROR. Negative not allowed: " + message.toString();
    }

    private static String getNumbersWithoutOptionalDelimiters(String numbers) {
        String numbersWithoutOptionalDelimiters = numbers;
        if (numbers.startsWith(PREFIX_NEW_DELIMITER)) {
            numbersWithoutOptionalDelimiters = numbers.substring(numbers.indexOf(END_NEW_DELIMITER) + 1);
        }
        return numbersWithoutOptionalDelimiters;
    }

    private static String getRegexDelimiter(String numbers) {
        String delimiter = DEFAULT_DELIMITERS;
        if (numbers.startsWith(PREFIX_NEW_DELIMITER)) {
            if (numbers.startsWith(PREFIX_NEW_DELIMITER + "[")) {
                delimiter = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
            } else {
                delimiter = numbers.substring(2, 3);
            }
            delimiter = delimiter.replace("*", "\\*");
        }

        return delimiter;
    }
}
