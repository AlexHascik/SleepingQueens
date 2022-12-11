import java.util.*;

public class Hand {

    private int playerIdx;
    private List<Card> cards;
    private List<Card> pickedCards;

    private DrawingAndThrashPile drawingAndThrashPile;

    public Hand(int playerIdx, DrawingAndThrashPile drawingAndThrashPile){
        this.playerIdx = playerIdx;
        cards = new ArrayList<>();
        pickedCards = new ArrayList<>();
        this.drawingAndThrashPile = drawingAndThrashPile;
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

        cards.removeAll(pickedCards);
        Map<HandPosition, Card> toReturn = new HashMap<>();
        List<Card> toDraw = drawingAndThrashPile.discardAndDraw(pickedCards);
        for(int i = 0; i < toDraw.size(); i++){
            toReturn.put(new HandPosition(i + cards.size(), playerIdx), toDraw.get(i));
        }
        cards.addAll(toDraw);
        returnPickedCards();
        return toReturn;
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
