package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderInfo {
    private List<String> players;
    private List<String> candidates;

    public LadderInfo(List<String> players, List<String> results) {
        if(players.size() != results.size()) { // 플레이어 수와 결과의 수가 다르면 예외처리
            throw new IllegalArgumentException();
        }
        this.players = new ArrayList<>(players);
        this.candidates = new ArrayList<>(results);
    }

    public void printPlayers() { // 모든 플레이어 출력
        for (String player : players) {
            System.out.printf("%-5s ", player);
        }
        System.out.println();
    }

    public void printCandidates() { // 모든 결과 출력
        for (String candidate : candidates) {
            System.out.printf("%-5s ", candidate);
        }
        System.out.println();
    }

    public void printPlayer(Integer result) {
        System.out.printf("%-5s", players.get(result));
    } // result인덱스에 맞는 플레이어 출력

    public void printCandidate(Integer result) {
        System.out.printf("%-5s", candidates.get(result));
    } // result인덱스에 맞는 결과 출력

    public int getPlayerNum() {
        return players.size();
    }

    public int getPlayerIndex(String player) {
        return players.indexOf(player);
    }
}

