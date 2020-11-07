package step3.car;

import step3.strategy.MoveStrategy;
import step3.strategy.PrintMarkStrategy;

import java.util.Random;
import java.util.stream.IntStream;

public class RacingCar implements Car {
    private int progress;
    private MoveStrategy moveStrategy;
    private final StringBuilder sb = new StringBuilder();
    private static final Random random = new Random();

    public RacingCar() {
        moveStrategy = MoveStrategy.defaultStrategy(random);
        progress = 0;
    }

    public RacingCar(MoveStrategy moveStrategy) {
        progress = 0;
        this.moveStrategy = moveStrategy;
    }


    @Override
    public void go() {
        if (allowMove()) {
            progress += 1;
        }
    }

    @Override
    public boolean allowMove() {
        return moveStrategy.strategy();
    }

    public boolean allowMove(int number) {
        return moveStrategy.strategy(number);
    }

    public void clearPrintMark(){
        sb.delete(0, sb.length());
    }

    @Override
    public StringBuilder getProgressFromStrategy(PrintMarkStrategy strategy) {
        clearPrintMark();
        IntStream.range(0,progress).forEach(index->sb.append(strategy.getPrintMark()));
        return sb;
    }

    @Override
    public int currentProgress() {
        return progress;
    }
}