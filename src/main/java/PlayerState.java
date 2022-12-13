import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    private Map<Integer, Queen> awokenQueens;
    public PlayerState(){
        cards = new HashMap<>();
        awokenQueens = new HashMap<>();
    }

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }
    public Map<Integer, Queen> getAwokenQueens(){
        return awokenQueens;
    }
    public void setCards(Map<Integer, Optional<Card>> cards){
        this.cards = new HashMap<>(cards);
    }
}
