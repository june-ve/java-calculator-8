package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력을 담당하는 View 클래스.
 */
public class InputView {

    /**
     * 덧셈 계산을 위한 문자열을 입력받아 반환한다.
     *
     * @return 사용자가 입력한 원본 문자열
     */
    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
