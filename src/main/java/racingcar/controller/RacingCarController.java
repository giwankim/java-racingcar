package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Cycle;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public static void main(String[] args) {
        String name = InputView.inputCarNames();
        Cycle cycle = new Cycle(InputView.inputCycle());
        Cars cars = new Cars(name.split(","));

        RacingGame racingGame = new RacingGame(cars, cycle);
        ResultView.showResult();
        while (!racingGame.isPlaying()) {
            racingGame.race();
            ResultView.showCarInformationDuringCycle(racingGame.getCars());
        }
        ResultView.showWinner(racingGame.selectWinners());
    }
}