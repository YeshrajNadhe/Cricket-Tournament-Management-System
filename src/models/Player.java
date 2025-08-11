package models;

public abstract class Player {
    protected String name;
    protected String role;
    protected int runs;
    protected int wickets;
    protected int matches;

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
        this.runs = 0;
        this.wickets = 0;
        this.matches = 0;
    }

    public void addRuns(int r) { runs += r; }
    public void addWickets(int w) { wickets += w; }
    public void addMatch() { matches++; }

    public String getName() { return name; }
    public int getRuns() { return runs; }
    public int getWickets() { return wickets; }
    public String getRole() { return role; }

    public abstract void displayStats();
}
