import java.util.*;

public class AwokenQueens extends QueenCollection{

    private final Map<Position, Queen> queens;
    private final int playerIdx;


    public AwokenQueens(int playerIdx){
        queens = new HashMap<>();
        this.playerIdx = playerIdx;
    }

    @Override
    public void addQueen(Queen queen) {
        queens.put(new AwokenQueenPosition(queens.size(), playerIdx), queen);
    }

    @Override
    public Optional<Queen> removeQueen(Position position) {
        return Optional.ofNullable(queens.remove((AwokenQueenPosition) position));
    }

    @Override
    public Map<Position, Queen> getQueens() {
        return queens;
    }
}
