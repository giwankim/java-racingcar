package step5.view;

import step5.domain.dto.RacingInfomation;
import step5.strategy.InputStrategy;

import java.util.Scanner;

public class InputView{
    private static final InputView inputView = new InputView();

    private InputView() { }

    public static InputView getInstance() {
        return inputView;
    }

    public RacingInfomation execute(InputStrategy strategy) {
        Scanner scanner = new Scanner(System.in);
        return strategy.question(scanner);
    }
}