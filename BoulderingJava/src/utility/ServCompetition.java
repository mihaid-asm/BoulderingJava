package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ServCompetition {
    private static List<Competition> competitions = new ArrayList<>();

    public static Competition startCompetition(String name) {
        Competition competition = new Competition(name);
        competitions.add(competition);
        System.out.println("Competition '" + name + "' started.");
        return competition;
    }

    public static void climberRegistersToCompetition(Climber climber, Competition competition, int score) {
        competition.addResult(climber, score);
        System.out.println("Climber '" + climber.getName() + "' registered to competition " + competition.getName() + ".");
    }

    public static void closeCompetitionRegistration(Competition competition) {
        competition.closeCompetition();
        System.out.println("Competition '" + competition.getName() + "' closed.");

        Set<Pair<Climber, Integer>> leaderboard = competition.getLeaderboard();
        if (!leaderboard.isEmpty()) {
            Pair<Climber, Integer> winnerEntry = leaderboard.iterator().next();
            ServBadge.assignBadge(winnerEntry.getKey(), ServBadge.getBadgeByName("Champion"));
        }
    }

    public static void showCompetition(Competition competition) {
        competition.printLeaderboard();
    }

    public static Competition getCompetitionByName(String name) {
        for (Competition comp : competitions) {
            if (comp.getName().equals(name)) return comp;
        }
        return null;
    }

    public static List<Competition> getCompetitions() {
        return competitions;
    }
}