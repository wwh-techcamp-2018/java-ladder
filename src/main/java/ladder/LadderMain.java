package ladder;

import java.util.List;
// 7.8 16:30 ~ 19:24
public class LadderMain {
    public static void main(String[] args) {
        LadderGenerator gn = new LadderGenerator();
        LadderFactory fac = new LadderFactory(gn);
        List<String> players = InputView.inputNamesAsList();
        List<String> candidates = InputView.inputResultsAsList();
        LadderInfo result = new LadderInfo(players, candidates);
        LadderGame game = new LadderGame(fac, result);
        // 게임 초기화와 진행 및 출력에 필요한 객체들 생성

        game.init(InputView.getTimes(), players.size());
        // 게임 진행(사다리 생성 및 결과 생성)

        OutputView.printLadderAll(game);
        OutputView.printResult(game, InputView.inputName());
        // 모든 사다리 출력 및 결과 출력

        return;
    }
}
