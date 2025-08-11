package services;

import models.*;
import java.util.*;

public class TournamentManager {
    private List<Team> teams = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();

    public Team createTeam(String name) {
        Team t = new Team(name);
        teams.add(t);
        return t;
    }

    public Player createPlayer(Team team, String name, String role) {
        Player p;
        switch (role.toLowerCase()) {
            case "batsman": p = new Batsman(name); break;
            case "bowler": p = new Bowler(name); break;
            default: p = new AllRounder(name); break;
        }
        team.addPlayer(p);
        return p;
    }

    public Match scheduleMatch(Team a, Team b) {
        Match m = new T20Match(a, b);
        matches.add(m);
        return m;
    }

    public void printPointsTable() {
        Collections.sort(teams);
        System.out.println("----- Points Table -----");
        for (Team t : teams) t.displayTeam();
    }

    public void printTopPerformers() {
        List<Player> allPlayers = new ArrayList<>();
        for (Team t : teams) allPlayers.addAll(t.getPlayers());

        allPlayers.sort((p1, p2) -> Integer.compare(p2.getRuns(), p1.getRuns()));
        System.out.println("Top Run Scorers:");
        for (int i = 0; i < Math.min(5, allPlayers.size()); i++) {
            Player p = allPlayers.get(i);
            System.out.printf("%d. %s - %d Runs%n", i + 1, p.getName(), p.getRuns());
        }

        allPlayers.sort((p1, p2) -> Integer.compare(p2.getWickets(), p1.getWickets()));
        System.out.println("Top Wicket Takers:");
        for (int i = 0; i < Math.min(5, allPlayers.size()); i++) {
            Player p = allPlayers.get(i);
            System.out.printf("%d. %s - %d Wickets%n", i + 1, p.getName(), p.getWickets());
        }
    }

    // ✅ Added getter method to avoid error in Main.java
    public List<Team> getAllTeams() {
        return teams;
    }
}
