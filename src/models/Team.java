package models;

import java.util.*;

public class Team implements Comparable<Team> {
    private String name;
    private List<Player> players;
    private int played, won, lost, tied, points;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Player> getPlayers() { return players; }
    public int getPoints() { return points; }

    public void addPlayer(Player p) { players.add(p); }

    public void recordResult(String result) {
        played++;
        switch (result.toLowerCase()) {
            case "win": won++; points += 2; break;
            case "loss": lost++; break;
            case "tie": tied++; points += 1; break;
        }
    }

    @Override
    public int compareTo(Team other) {
        return Integer.compare(other.points, this.points);
    }

    public void displayTeam() {
        System.out.printf("Team %s - P:%d W:%d L:%d T:%d Pts:%d%n",
                name, played, won, lost, tied, points);
    }
}
