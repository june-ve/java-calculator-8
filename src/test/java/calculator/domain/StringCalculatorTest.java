package calculator.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void 빈_문자열_입력_시_0_반환() {
        // given
        String input = "";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나_입력_시_해당_숫자_반환() {
        // given
        String input = "12";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 기본_구분자로_숫자_합산() {
        // given
        String input = "12,3:456";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(471);
    }

    @Test
    void 커스텀_구분자로_숫자_합산() {
        // given
        String input = "//;\\n12;3;456";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(471);
    }

    @Test
    void 음수_입력_시_예외_발생() {
        // given
        String input = "12,-3:456";

        // when & then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_외_문자_입력_시_예외_발생() {
        // given
        String input = "12,3,a";

        // when & then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
