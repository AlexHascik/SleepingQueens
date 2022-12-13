import java.util.Map;
import java.util.Optional;

public class GameFinished implements GameFinishedStrategy{

    private int scoreToReach;
    private int queensToReach;
    private Map<Integer, AwokenQueens> playerAwokenQueens;
    public GameFinished(Map<Integer, AwokenQueens> playerAwokenQueens, int numberOfPlayers){
        this.playerAwokenQueens = playerAwokenQueens;

        if(numberOfPlayers == 2 || numberOfPlayers == 3){
            scoreToReach = 50;
            queensToReach = 5;
        } else if(numberOfPlayers == 4 || numberOfPlayers == 5){
            scoreToReach = 40;
            queensToReach = 4;
        }
    }

    @Override
    public Optional<Integer> isFinished() {

        for(Map.Entry<Integer, AwokenQueens> entry : playerAwokenQueens.entrySet()){
            int playerIdx = entry.getKey();
            int score = 0;
            int queens = entry.getValue().getQueens().size();
            if(queens >= queensToReach){
                return Optional.of(playerIdx);
            }
            for(Queen queen : entry.getValue().getQueens().values()){
                score += queen.getPoints();
            }
            if(score >= scoreToReach){
                return Optional.of(playerIdx);
            }
        }
        return Optional.empty();
    }
}
