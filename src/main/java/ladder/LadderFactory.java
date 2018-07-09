package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private final int NONCE = 6;
    private Generator gn;
    private boolean previous = false; // |-----|-----| 와 연속적인 사다리를 막기위한 flag

    public LadderFactory(Generator gn) {
        this.gn = gn;
    }

    public Ladder createLadder(int limit) {
        List<Boolean> bools = new ArrayList<>();
        for (int i = 0; i < limit-1; i++) {
            bools.add(makeOrNot());
            // 사다리 생성을 위한 boolean 리스트 생성
        }
        previous = false;
        return new Ladder(bools);
    }

    private boolean makeOrNot() {
        return makeOrNot(NONCE);
    }
    // 난이도값을 지정하지않으면 Default 난이도로 사다리 생성. 높을수록 사다리가 생길 확률이 높다

    private boolean makeOrNot(int Nonce) {
        if(!previous && gn.generate() < NONCE) { // generator로 사다리 생성여부 반환 + 중복방지
            previous = true;
            return true;
        }
        previous = false;
        return false;
    }
}
