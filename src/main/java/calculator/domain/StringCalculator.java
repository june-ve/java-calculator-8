package calculator.domain;

import java.util.Arrays;

/**
 * 문자열로 전달된 숫자들의 합을 계산하는 클래스.
 * <p>
 * 입력 문자열을 구분자 단위로 분리하고, 숫자로 변환한 뒤 합산한다.
 * 기본 구분자는 쉼표(,)와 콜론(:)이며,
 * "//"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 지정할 수 있다.
 */
public class StringCalculator {

    private final DelimiterProcessor delimiterProcessor = new DelimiterProcessor();
    private final NumberParser numberParser = new NumberParser();

    /**
     * 주어진 문자열의 숫자 합계를 계산한다.
     *
     * @param input 덧셈할 숫자들이 포함된 문자열
     * @return 계산된 합계
     */
    public int add(String input) {
        // TODO: 빈 문자열("") 입력 시 0 반환

        String[] tokens = delimiterProcessor.splitByDelimiters(input);
        int[] numbers = numberParser.parseToNumbers(tokens);

        return sum(numbers);
    }

    /**
     * 숫자 배열의 모든 값을 더해 합계를 반환한다.
     * <p>
     * 현재는 단순 합산만 수행하지만, 추후 조건부 합산
     * (예: 1000 초과 값 제외, 특정 조건만 합산 등)을 추가할 수 있다.
     *
     * @param numbers 합산할 정수 배열
     * @return 배열 내 모든 숫자의 합
     */
    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

}
