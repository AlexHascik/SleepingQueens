import java.util.*;

public class SleepingQueens extends QueenCollection{

    private Map<Position, Queen> queens;

    public SleepingQueens(){

        //list of possible points
        Integer [] points = {5, 5, 5, 5, 10, 10, 10, 10, 15, 15, 15, 20};
        ArrayList<Integer> pointsList = new ArrayList<>(Arrays.asList(points));
        //shuffle points so when creating new queens points are random
        Collections.shuffle(pointsList);
        queens = new HashMap<>();
        for(int i = 0; i < 12; i++){ addQueen(new Queen(pointsList.get(i)));}
    }

    @Override
    void addQueen(Queen queen) {
        queens.put(new SleepingQueenPosition(queens.size()), queen);
    }

    @Override
    Optional<Queen> removeQueen(SleepingQueenPosition position) {
        return Optional.ofNullable(queens.remove(position));
    }

    @Override
    Map<Position, Queen> getQueens() {
        return queens;
    }
}
