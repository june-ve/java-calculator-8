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
     * @throws IllegalArgumentException 숫자가 아닌 값이 포함된 경우
     */
    int[] parseToNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            // TODO: 음수 값이 들어온 경우 IllegalArgumentException 발생 처리
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        return numbers;
    }

}
