import java.util.*;

public class AwokenQueens extends QueenCollection{

    private final Map<Position, Queen> queens;
    private final Player player;

    public AwokenQueens(Player player){
        queens = new HashMap<>();
        this.player = player;
    }

    @Override
    public void addQueen(Queen queen) {
        queens.put(new AwokenQueenPosition(queens.size(), player.getPlayerIdx()), queen);
    }

    @Override
    public Optional<Queen> removeQueen(SleepingQueenPosition position) {
        return Optional.ofNullable(queens.remove(position));
    }

    @Override
    public Map<Position, Queen> getQueens() {
        return queens;
    }
}
