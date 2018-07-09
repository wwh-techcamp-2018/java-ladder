package ladder;

public class OutputView {
    public static void printLadderAll(LadderGame game) {
        System.out.println("\n사다리 결과");
        game.printAllLadders();
    } // 모든 사다리 출력

    public static void printResult(LadderGame game, String player) {
        System.out.println("\n실행결과");
        if(player.equals("all")) {
            game.printAllResults();
            return;
        } // Player입력에 해당하는 결과 출력
        game.printPlayer(player);
    }


}
