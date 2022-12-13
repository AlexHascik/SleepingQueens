import java.util.Map;
import java.util.Optional;

public class MoveQueen {

    private Map<Integer, Hand> playerHands;
    private SleepingQueens sleepingQueens;

    private CardType attackType;

    private Map<Integer, AwokenQueens> playerAwokenQueens;
    public MoveQueen(Map<Integer, Hand> playerHands, SleepingQueens sleepingQueens, Map<Integer, AwokenQueens> playerAwokenQueens){
        this.playerHands = playerHands;
        this.sleepingQueens = sleepingQueens;
    }

    //called when king or knight is played
    public boolean play(Position targetQueen, int playerIdx){
        if(targetQueen instanceof SleepingQueenPosition){
            Optional<Queen> removed = sleepingQueens.removeQueen((SleepingQueenPosition) targetQueen);
            if (removed.isPresent()) {
                playerAwokenQueens.get(playerIdx).addQueen(removed.get());
                return true;
            }

        } else if(targetQueen instanceof AwokenQueenPosition){
            int targetPlayerIdx = ((AwokenQueenPosition) targetQueen).getPlayerIndex();
            Optional<Queen> removed = playerAwokenQueens.get(targetPlayerIdx).removeQueen(targetQueen);
            if(removed.isPresent()){
                playerAwokenQueens.get(playerIdx).addQueen(removed.get());
                return true;
            }
        }
        return false;
    }

    // is called when sleeping potion is played
    public boolean play(Position targetQueen){
        if(!(targetQueen instanceof AwokenQueenPosition)){ return false;}
        int targetPlayerIdx = ((AwokenQueenPosition) targetQueen).getPlayerIndex();
        Optional<Queen> removed = playerAwokenQueens.get(targetPlayerIdx).removeQueen(targetQueen);
        if (removed.isPresent()) {
            sleepingQueens.addQueen(removed.get());
            return true;
        }
        return false;
    }



}
