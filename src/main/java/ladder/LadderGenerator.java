package ladder;

import java.util.Random;

public class LadderGenerator implements Generator {
    private static final int DEFAULT_LIMIT = 10;
    Random random = new Random();

    @Override
    public int generate() {
        return generate(DEFAULT_LIMIT);
    }

    private int generate(int limit) {
        return random.nextInt(limit);
    }
}
