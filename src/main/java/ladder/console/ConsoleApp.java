package ladder.console;

import ladder.console.view.InputView;
import ladder.console.view.OutputView;
import ladder.domain.ladder.DefaultLadderFactory;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.player.Players;
import ladder.service.LadderGameService;

public class ConsoleApp {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final LadderFactory ladderFactory = new DefaultLadderFactory();
        final LadderGameService ladderGameService = new LadderGameService(ladderFactory);

        final Players players = ladderGameService.createPlayers(inputView.inputNames());
        final int height = inputView.inputHeight();

        final Ladder ladder = ladderGameService.createLadder(height, players.size());

        outputView.printPlayers(players);
        outputView.printLadder(ladder);
    }


}