package models;

public class Batsman extends Player {
    public Batsman(String name) {
        super(name, "Batsman");
    }

    @Override
    public void displayStats() {
        System.out.printf("%s (Batsman) - Matches: %d, Runs: %d%n", name, matches, runs);
    }
}
