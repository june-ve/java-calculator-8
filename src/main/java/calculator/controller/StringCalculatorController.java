package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 사용자 입력을 받아 계산을 수행하고,
 * 그 결과를 출력하는 애플리케이션의 흐름을 제어하는 클래스.
 */
public class StringCalculatorController {

    private final StringCalculator calculator = new StringCalculator();

    /**
     * 계산 프로세스를 실행한다.
     * <p>
     * 1. 사용자로부터 문자열 입력을 받는다.
     * 2. 계산기에 입력 문자열을 전달하여 결과를 얻는다.
     * 3. 계산 결과를 출력한다.
     */
    public void run() {
        String input = InputView.readInput();
        int result = calculator.add(input);
        OutputView.printResult(result);
    }
}
