package calculator.domain;

/**
 * 문자열 배열을 정수 배열로 변환하는 클래스.
 * <p>
 * 각 문자열이 정수로 변환 가능한지 확인하며, 변환 불가 시
 * {@link IllegalArgumentException}을 발생시킨다.
 */
public class NumberParser {

    /**
     * 문자열 배열을 정수 배열로 변환한다.
     *
     * @param tokens 숫자 문자열 배열
     * @return 변환된 정수 배열
     * @throws IllegalArgumentException 숫자가 아닌 값 또는 음수가 포함된 경우
     */
    int[] parseToNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            int number = parseSingleNumber(tokens[i]);
            validateNonNegative(number);
            numbers[i] = number;
        }

        return numbers;
    }

    /**
     * 문자열 토큰을 정수로 변환한다.
     *
     * @param token 변환할 문자열 토큰
     * @return 변환된 정수 값
     * @throws IllegalArgumentException 숫자로 변환할 수 없는 경우
     */
    private int parseSingleNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + token);
        }
    }

    /**
     * 음수 값이 존재하는 경우 예외를 발생시킨다.
     *
     * @param number 검증할 숫자
     * @throws IllegalArgumentException 음수가 입력된 경우
     */
    private void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
