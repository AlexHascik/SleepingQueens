import java.util.*;

public class GameState {

    public int numberOfPlayers;
    public int onTurn;
    public Set<SleepingQueenPosition> sleepingQueens;
    public Map<HandPosition, Optional<Card>> cards; // AKE KARTY...?
    public Map<AwokenQueenPosition, Queen> awokenQueens;
    public List<Card> cardsDiscardedLastTurn;

    public GameState(int numberOfPlayers, int onTurn){
        this.numberOfPlayers = numberOfPlayers;
        this.onTurn = onTurn;
        sleepingQueens = new HashSet<SleepingQueenPosition>();
        for(int i = 0; i < 12; i++){
            sleepingQueens.add(new SleepingQueenPosition(i));
        }
        awokenQueens = new HashMap<>();
        cardsDiscardedLastTurn = new ArrayList<>();

    }
}
