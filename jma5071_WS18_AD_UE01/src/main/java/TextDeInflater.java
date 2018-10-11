/**
 * @author Janik Mayr on 11.10.2018
 */
class TextDeInflater {
    static String deflate(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int consecutive;
        for (int i = 0; i < input.length(); i++) {
            consecutive = 0;
            while (i+1 < input.length() && input.charAt(i) == input.charAt(i+1)) {
                consecutive++;
                i++;
            }
            if (i+1 < input.length()) {
                    if (consecutive < 10) {
                        if (consecutive < 2) {
                            stringBuilder.append(
                                    lessThanThree(consecutive,input.charAt(i))
                            );
                        } else {
                            stringBuilder.append(consecutive).append(input.charAt(i));
                        }
                    } else {
                        stringBuilder.append(moreThanNine(consecutive,input.charAt(i)));
                    }
            } else {
                stringBuilder.append(lessThanThree(consecutive,input.charAt(i)));
            }
        }
        return stringBuilder.toString();
    }

    private static String lessThanThree(int consecutive, Character ch) {
        StringBuilder stringBuilder = new StringBuilder();
        int number = ch - '0';
        if (number < 10 && number >= 0) {
            stringBuilder.append(consecutive).append(ch);
        } else {
            for (int i = 0; i <= consecutive; i++) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    private static String moreThanNine(int consecutive, Character ch) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("8").append(ch);
        consecutive-=9;
        if (consecutive < 2) {
            stringBuilder.append(lessThanThree(consecutive,ch));
        } else {
            if (consecutive < 10) {
                stringBuilder.append(consecutive).append(ch);
            } else {
                stringBuilder.append(moreThanNine(consecutive,ch));
            }
        }
        return stringBuilder.toString();
    }

    static String inflate(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int number;
        for (int i = 0; i < input.length(); i++) {
            if (i+1 < input.length()) {
                number = input.charAt(i)-'0';
                if (number < 10 && number >=0) {
                    stringBuilder.append(multiplyChar(input.charAt(i),input.charAt(i+1))); //ADJUST rep number +/- 1
                    i++;
                } else {
                    stringBuilder.append(input.charAt(i));
                }
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static String multiplyChar(Character repetitions, Character ch) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= repetitions-'0'; i++) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
