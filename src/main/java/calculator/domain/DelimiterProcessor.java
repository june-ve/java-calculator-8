package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력 문자열에서 구분자를 식별하고, 해당 구분자 기준으로 문자열을 분리하는 클래스.
 * <p>
 * 기본 구분자는 쉼표(,)와 콜론(:)이며,
 * "//"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 지정할 수 있다.
 */
public class DelimiterProcessor {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    /**
     * 입력 문자열에 커스텀 구분자가 존재하는 경우 커스텀 구분자를 기준으로 분리하고,
     * 그렇지 않은 경우 기본 구분자(쉼표, 콜론)를 기준으로 분리한다.
     *
     * @param input 원본 입력 문자열
     * @return 구분된 문자열 배열
     */
    String[] splitByDelimiters(String input) {
        if (hasCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        }
        return splitByDefaultDelimiters(input);
    }

    /**
     * 입력 문자열이 커스텀 구분자 형식을 포함하는지 확인한다.
     *
     * @param input 원본 입력 문자열
     * @return 커스텀 구분자 존재 여부
     */
    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    /**
     * 커스텀 구분자를 패턴에서 추출하고, 이를 기준으로 숫자 문자열을 분리한다.
     *
     * @param input 원본 입력 문자열
     * @return 커스텀 구분자로 분리된 숫자 문자열 배열
     * @throws IllegalArgumentException 커스텀 구분자 형식이 올바르지 않은 경우
     */
    private String[] splitByCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다: " + input);
        }

        String customDelimiter = matcher.group(1);
        String numbersPart = matcher.group(2);
        return numbersPart.split(Pattern.quote(customDelimiter));
    }

    /**
     * 기본 구분자(쉼표, 콜론)를 기준으로 숫자 문자열을 분리한다.
     *
     * @param input 원본 입력 문자열
     * @return 기본 구분자로 분리된 숫자 문자열 배열
     */
    private String[] splitByDefaultDelimiters(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

}
