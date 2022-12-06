import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MoveQueen {

    private Map<Integer, Hand> playerHands;
    private SleepingQueens sleepingQueens;
    public MoveQueen(Map<Integer, Hand> playerHands, SleepingQueens sleepingQueens){
        this.playerHands = playerHands;
        this.sleepingQueens = sleepingQueens;
    }

    public boolean play(Position targetQueen, int playerIdx){
        if(targetQueen instanceof SleepingQueenPosition){
            Optional<Queen> removed = sleepingQueens.removeQueen((SleepingQueenPosition) targetQueen);
            if (removed.isPresent()) {
//                playerHands.get(playerIdx).
            }
        }
        return false;
    }


}
