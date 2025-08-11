import models.*;
import services.TournamentManager;
import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static TournamentManager manager = new TournamentManager();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt();
            switch (choice) {
                case 1: createTeam(); break;
                case 2: addPlayer(); break;
                case 3: scheduleMatch(); break;
                case 4: recordMatchResult(); break;
                case 5: manager.printPointsTable(); break;
                case 6: manager.printTopPerformers(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== T20 Cricket Tournament ===");
        System.out.println("1. Create Team");
        System.out.println("2. Add Player to Team");
        System.out.println("3. Schedule Match");
        System.out.println("4. Record Match Result");
        System.out.println("5. Show Points Table");
        System.out.println("6. Show Top Performers");
        System.out.println("7. Exit");
        System.out.print("Choose: ");
    }

    private static void createTeam() {
        System.out.print("Enter team name: ");
        String name = sc.nextLine();
        manager.createTeam(name);
        System.out.println("Team created successfully.");
    }

    private static void addPlayer() {
        System.out.print("Enter team name: ");
        String name = sc.nextLine();
        Team team = findTeamByName(name);
        if (team == null) { System.out.println("Team not found"); return; }
        System.out.print("Player name: ");
        String pname = sc.nextLine();
        System.out.print("Role (Batsman/Bowler/AllRounder): ");
        String role = sc.nextLine();
        manager.createPlayer(team, pname, role);
        System.out.println("Player added.");
    }

    private static void scheduleMatch() {
        System.out.print("Enter Team A name: ");
        Team a = findTeamByName(sc.nextLine());
        System.out.print("Enter Team B name: ");
        Team b = findTeamByName(sc.nextLine());
        if (a == null || b == null) { System.out.println("One or both teams not found."); return; }
        manager.scheduleMatch(a, b);
        System.out.println("Match scheduled.");
    }

    private static void recordMatchResult() {
        System.out.print("Enter Team A name: ");
        Team a = findTeamByName(sc.nextLine());
        System.out.print("Enter Team B name: ");
        Team b = findTeamByName(sc.nextLine());
        if (a == null || b == null) { System.out.println("Teams not found."); return; }

        System.out.print("Team A runs: "); int ar = readInt();
        System.out.print("Team B runs: "); int br = readInt();

        // Update team points
        Match match = new T20Match(a, b);
        match.finalizeResult(ar, br);

        // Update player stats
        System.out.println("Enter player stats for " + a.getName());
        for (Player p : a.getPlayers()) {
            System.out.print(p.getName() + " runs: "); p.addRuns(readInt());
            System.out.print(p.getName() + " wickets: "); p.addWickets(readInt());
            p.addMatch();
        }
        System.out.println("Enter player stats for " + b.getName());
        for (Player p : b.getPlayers()) {
            System.out.print(p.getName() + " runs: "); p.addRuns(readInt());
            System.out.print(p.getName() + " wickets: "); p.addWickets(readInt());
            p.addMatch();
        }
        System.out.println("Match result recorded.");
    }

    private static Team findTeamByName(String name) {
        for (Team t : manager.getAllTeams()) {
            if (t.getName().equalsIgnoreCase(name)) return t;
        }
        return null;
    }

    private static int readInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { return -1; }
    }
}
