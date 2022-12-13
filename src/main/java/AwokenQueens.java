import java.util.*;

public class AwokenQueens extends QueenCollection{

    private final Map<Position, Queen> queens;
    private final int playerIdx;
    private Stack<Integer> emptyPlaces;


    public AwokenQueens(int playerIdx){
        queens = new HashMap<>();
        this.playerIdx = playerIdx;
        emptyPlaces = new Stack<>();
    }

    @Override
    public void addQueen(Queen queen) {

        if(emptyPlaces.isEmpty()){
            queens.put(new AwokenQueenPosition(queens.size(), playerIdx), queen);
        } else{
            queens.put(new AwokenQueenPosition(emptyPlaces.pop(), playerIdx), queen);
        }

    }

    @Override
    public Optional<Queen> removeQueen(Position position) {

        Optional<Queen> toRemove = Optional.ofNullable(queens.remove(position));
        if(toRemove.isPresent()){
            emptyPlaces.push(position.getCardIndex());
        }
        return toRemove;
    }

    @Override
    public Map<Position, Queen> getQueens() {
        return queens;
    }
}
