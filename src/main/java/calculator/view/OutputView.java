package calculator.view;

/**
 * 계산 결과를 사용자에게 출력하는 View 클래스.
 */
public class OutputView {

    /**
     * 계산된 덧셈 결과를 콘솔에 표시한다.
     *
     * @param result 합산 결과 값
     */
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
