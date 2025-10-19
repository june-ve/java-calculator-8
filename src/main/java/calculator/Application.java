package calculator;

import calculator.controller.StringCalculatorController;

public class Application {
    public static void main(String[] args) {
        StringCalculatorController controller = new StringCalculatorController();
        controller.run();
    }
}
