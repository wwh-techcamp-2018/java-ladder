package ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ladderTest {

    @Test
    public void ladderTest() {
        Ladder ladder = new Ladder(Arrays.asList(true, false, true));
        assertThat(ladder.getNextMove(0)).isEqualTo(1);
        assertThat(ladder.getNextMove(1)).isEqualTo(0);
        assertThat(ladder.getNextMove(2)).isEqualTo(3);
        assertThat(ladder.getNextMove(3)).isEqualTo(2);
    }

    @Test
    public void ladderInfoTest() {
        List<String> players = Arrays.asList("pobi", "honux", "crong");
        List<String> candidates = Arrays.asList("1000", "3000", "5000");
        LadderInfo info = new LadderInfo(players, candidates);
        assertThat(info.getPlayerIndex("honux")).isEqualTo(1);
    }
}
