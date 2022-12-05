import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class QueenCollection {

    private Map<Position, Queen> queens = new HashMap<>();
    private int index = 0;
    public void addQueen(Queen queen){
        queens.put(new SleepingQueenPosition(index), queen);
        index++;
    }
    public Optional<Queen> removeQueen(SleepingQueenPosition position){
        return Optional.ofNullable(queens.remove(position));
    }
    public Map<Position, Queen> getQueens(){
        return queens;
    }
}
