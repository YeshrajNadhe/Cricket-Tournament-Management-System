package models;

public class AllRounder extends Player {
    public AllRounder(String name) {
        super(name, "AllRounder");
    }

    @Override
    public void displayStats() {
        System.out.printf("%s (AllRounder) - Matches: %d, Runs: %d, Wickets: %d%n", name, matches, runs, wickets);
    }
}
