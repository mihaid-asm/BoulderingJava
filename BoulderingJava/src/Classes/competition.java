package Classes;

import Utility.Pair;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class competition {
    private String name;
    private Set<Pair<climber, Integer>> leaderboard;
    private Boolean open = true;

    public competition(String name) {
        this.name = name;
        this.leaderboard = this.leaderboard = new TreeSet<>(Comparator.comparing(Pair<climber, Integer>::getValue).reversed());
    }

    public String getName() {
        return name;
    }

    public Set<Pair<climber, Integer>> getLeaderboard() {
        return leaderboard;
    }

    public Boolean getOpen() {
        return open;
    }

    public void closeCompetition() {
        this.open = false;
    }

    public void addResult(climber climber, int score) {
        if (!open) {
            System.out.println("Competition is closed. No more results can be added.");
            return;
        }
        leaderboard.add(new Pair<>(climber, score));
    }

    public void printLeaderboard() {
        System.out.println((!open ? "Full " : "Partial ") + "Leaderboard for Competition: " + name);

        int rank = 1;
        for (Pair<climber, Integer> entry : leaderboard) {
            System.out.println(rank + ". " + entry.getKey().getName() + " - " + entry.getValue() + " points");
            rank++;
        }
    }

    @Override
    public String toString() {
        return "competition{" +
                "name='" + name + '\'' +
                ", leaderboard=" + leaderboard +
                ", open=" + open +
                '}';
    }
}
