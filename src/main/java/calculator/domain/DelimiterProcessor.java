package calculator.domain;

/**
 * 입력 문자열에서 구분자를 식별하고, 해당 구분자 기준으로 문자열을 분리하는 클래스.
 * <p>
 * 기본 구분자는 쉼표(,)와 콜론(:)이며,
 * "//"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 지정할 수 있다.
 */
public class DelimiterProcessor {

    private static final String DEFAULT_DELIMITERS = ",|:";

    /**
     * 입력 문자열을 구분자 기준으로 분리한다.
     *
     * @param input 원본 입력 문자열
     * @return 구분된 문자열 배열
     */
    String[] splitByDelimiters(String input) {
        // TODO: 커스텀 구분자로 분리하는 기능 추가
        return input.split(DEFAULT_DELIMITERS);
    }

}
