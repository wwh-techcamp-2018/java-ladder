package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private List<Ladder> ladders = new ArrayList<>();
    private LadderFactory fac;
    private LadderInfo info; // 플레이어 정보와 실행결과를 가지고있음
    private List<Integer> results; // i번째 인덱스의 플레이어의 마지막 위치값을 저장

    public LadderGame(LadderFactory fac, LadderInfo info) {
        this.fac = fac;
        this.info = info;
    }

    public void init(int height, int playerNum) { // 사다리를 생성하고 사다리 결과를 만들어줌
        for (int i = 0; i < height; i++) {
            ladders.add(fac.createLadder(playerNum));
        }
        updateResult();
    }

    public void printAllLadders() { // 참가자 + 모든사다리 + 결과출력
        info.printPlayers();
        for (Ladder ladder : ladders) {
            ladder.printLadder();
        }
        info.printCandidates();
    }

    public void updateResult() { // 사다리 결과 업데이트
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < info.getPlayerNum(); i++) {
            result.add(getResult(i)); // i번째 플레이어의 사다리 결과를 차례로 추가
        }
        this.results = result;
    }

    private int getResult(int index) {
        int current = index;
        for (Ladder ladder : ladders) { // 사다리를 돌며 i번째 플레이어의 결과를 얻어온다.
            current = getNextLocation(ladder, current); // 사다리 한층한층씩 움직이며 결과를 얻음
        }
        return current;
    }

    private int getNextLocation(Ladder ladder, int index) { // 해당 층에서의 위치계산
        return ladder.getNextMove(index);
    }

    public void printAllResults() {  // 모든 플레이어의 결과 출력
        for (int i = 0; i < info.getPlayerNum(); i++) {
            info.printPlayer(i);
            System.out.print(" : ");
            info.printCandidate(results.get(i)); // 플레이어 인덱스에 맞는 결과값 출력
            System.out.println();
        }
    }

    public void printPlayer(String player) { // 해당 플레이어의 결과만 출력
        info.printCandidate(results.get(info.getPlayerIndex(player)));
    }
}
