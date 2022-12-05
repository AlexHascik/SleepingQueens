import java.util.*;

public class Hand {

    private int playerIdx;
    private List<Card> cards;
    private List<Card> pickedCards;

    public Hand(int playerIdx){
        this.playerIdx = playerIdx;
        cards = new ArrayList<>();
        pickedCards = new ArrayList<>();
    }

    public Optional<List<Card>> pickCards(List<HandPosition> positions){

        if(!positions.isEmpty()){
            for(HandPosition position : positions){
                pickedCards.add(cards.get(position.getCardIndex()));
            }
            return Optional.of(pickedCards);
        }
        return Optional.empty();
    }
    public Map<HandPosition, Card> removePickedCardsAndRedraw(){
        return null;
    }
    public void returnPickedCards(){
        pickedCards.clear();
    }
    public HandPosition hasCardOfType(CardType type){

        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getCardType() == type){
                return new HandPosition(i, playerIdx);
            }
        }

        return null;
    }
    public List<Card> getCards(){
        return cards;
    }

}
