import java.util.*;

public class GameState {

    private int numberOfPlayers;
    private int onTurn;
    private Set<SleepingQueenPosition> sleepingQueens;
    private Map<HandPosition, Optional<Card>> cards;
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

    public Set<SleepingQueenPosition> getSleepingQueens(){
        return sleepingQueens;
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

    public Map<HandPosition, Optional<Card>> getCards(){
        return cards;
    }
    public List<Card> getCardsDiscardedLastTurn(){
        return cardsDiscardedLastTurn;
    }
    public void setAwokenQueens(Map<AwokenQueenPosition, Queen> awokenQueens){
        this.awokenQueens = new HashMap<>(awokenQueens);
    }
    public Map<AwokenQueenPosition, Queen> getAwokenQueens(){
        return awokenQueens;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public String toString(){
        String s1 = "Number of players: " + numberOfPlayers + "\n";
        String s2 = "On turn " + onTurn + "\n";
        String s3 = "Sleeping Queens positions: " + sleepingQueens + "\n";
        String s4 = "Awoken Queens positions: " + awokenQueens + "\n";
        String s5 = "Cards discarded last turn: " + cardsDiscardedLastTurn + "\n";
//        String s6 = "Cards: " + cards + "\n"; asi by sa nemalo vypisovat

        return s1 + s2 + s3 + s4 + s5;
    }



}
