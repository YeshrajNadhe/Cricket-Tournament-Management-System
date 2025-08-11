package models;

public abstract class Match {
    protected Team teamA;
    protected Team teamB;
    protected int oversPerSide;
    protected String result;

    public Match(Team teamA, Team teamB, int overs) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.oversPerSide = overs;
    }

    public Team getTeamA() { return teamA; }
    public Team getTeamB() { return teamB; }
    public String getResult() { return result; }

    public void finalizeResult(int teamARuns, int teamBRuns) {
        if (teamARuns > teamBRuns) {
            result = "A";
            teamA.recordResult("win");
            teamB.recordResult("loss");
        } else if (teamBRuns > teamARuns) {
            result = "B";
            teamB.recordResult("win");
            teamA.recordResult("loss");
        } else {
            result = "Tie";
            teamA.recordResult("tie");
            teamB.recordResult("tie");
        }
    }
}
