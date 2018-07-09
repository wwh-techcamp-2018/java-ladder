package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final String VERTICAL = "|";
    private final String HORIZONTAL = "-----";
    private List<Boolean> ladder = new ArrayList<>();
    // Boolean리스트로 사다리 하나를 표현.
    // Ex) |-----|     |-----|  => { true, false, true }

    public Ladder(List<Boolean> booleans) {
        for (boolean bool : booleans) {
            ladder.add(bool);
        }
    }

    public void printLadder() {
        printLadder(VERTICAL, HORIZONTAL);
    }

    public void printLadder(String vertical, String horizontal) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < ladder.size(); i++) {
            sb.append(vertical);
            sb.append((ladder.get(i))? HORIZONTAL : "     ");
        }
        sb.append(vertical);
        System.out.println(sb.toString());
        // 가지고있는 Boolean 리스트 기반으로 사다리 모양 생성하여 출력
    }

    public int getNextMove(int index) {
        if(index != 0 && ladder.get(index - 1)) {
            return index - 1;
        }
        if(index != ladder.size() && ladder.get(index)) {
            return index + 1;
        }
        return index;
        // Boolean 리스트를 참고하여 왼쪽으로 이동할지 오른쪽으로 이동할지 그대로 있을지 인덱스를 반환
    }
}
