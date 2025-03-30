package task0926;

public class Result {
    private String gameId;
    private String subGameId;
    private String targetId;
    private double point = 0.0;

    public Result(String gameId, String subGameId, String targetId) {
        this.gameId = gameId;
        this.subGameId = subGameId;
        this.targetId = targetId;
    }

    public void addPoint(double point) {
        this.point += point;
    }

    public double getPoint() {
        return point;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getGameId() {
        return gameId;
    }

    public String getSubGameId() {
        return subGameId;
    }
}
