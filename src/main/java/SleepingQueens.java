import java.util.*;

public class SleepingQueens extends QueenCollection{

    private Map<Position, Queen> queens;
    private Stack<Integer> emptyPlaces;

    public SleepingQueens(){
        //list of possible points
        Integer [] points = {5, 5, 5, 5, 10, 10, 10, 10, 15, 15, 15, 20};
        ArrayList<Integer> pointsList = new ArrayList<>(Arrays.asList(points));
        //shuffle points so when creating new queens points are random
        Collections.shuffle(pointsList);
        queens = new HashMap<>();
        emptyPlaces = new Stack<>();
        for(int i = 0; i < 12; i++){ addQueen(new Queen(pointsList.get(i)));}
    }

    @Override
    void addQueen(Queen queen) {
        if(emptyPlaces.isEmpty()){
            queens.put(new SleepingQueenPosition(queens.size()), queen);
        } else {
            queens.put(new SleepingQueenPosition(emptyPlaces.pop()), queen);
        }
    }

    @Override
    Optional<Queen> removeQueen(Position position) {
        Optional<Queen> toRemove = Optional.ofNullable(queens.remove(position));
        if (toRemove.isPresent()) {
            emptyPlaces.push(((SleepingQueenPosition)position).getCardIndex());
        }
        return toRemove;
    }

    @Override
    Map<Position, Queen> getQueens() {
        return queens;
    }


}
