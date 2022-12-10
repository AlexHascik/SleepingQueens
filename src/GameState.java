import java.util.*;

public class GameState {

    private int numberOfPlayers;
    private int onTurn;
    private Set<SleepingQueenPosition> sleepingQueens;
    private Map<HandPosition, Optional<Card>> cards; //AKE KARTY...?
    private Map<AwokenQueenPosition, Queen> awokenQueens;
    private List<Card> cardsDiscardedLastTurn;

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

    public void setSleepingQueens(Set<SleepingQueenPosition> sleepingQueens){
        this.sleepingQueens = new HashSet<>(sleepingQueens);
    }

    public void setOnTurn(int onTurn){
        this.onTurn = onTurn;
    }

    public int getOnTurn( ){
        return onTurn;
    }

    public void setCards(Map<HandPosition, Optional<Card>> cards){
        this.cards = new HashMap<>(cards);
    }

    public void setAwokenQueens(Map<AwokenQueenPosition, Queen> awokenQueens){
        this.awokenQueens = new HashMap<>(awokenQueens);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
