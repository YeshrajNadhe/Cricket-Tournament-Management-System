package models;

public class Bowler extends Player {
    public Bowler(String name) {
        super(name, "Bowler");
    }

    @Override
    public void displayStats() {
        System.out.printf("%s (Bowler) - Matches: %d, Wickets: %d%n", name, matches, wickets);
    }
}
