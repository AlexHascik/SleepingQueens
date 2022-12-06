import java.util.*;

public class DrawingAndThrashPile {

    //vytvaranie

    private final ArrayList<Card> drawingPile;
    private ArrayList<Card> thrashPile;
    private final ArrayList<Card> discardedThisTurn;
    private ShuffleStrategy shuffleStrategy;


    public DrawingAndThrashPile(){
        drawingPile = new ArrayList<>();
        thrashPile = new ArrayList<>();
        discardedThisTurn = new ArrayList<>();
        shuffleStrategy = new ShuffleStrategyA();
        addCards();
    }

    //vytvori drawingPile so vsetkymi kartami, zamiesa;
    private void addCards(){
        for(int i = 0; i < 8; i++){ drawingPile.add(new Card(CardType.KING, 0));}
        for(int i  = 0; i < 4; i++){
            drawingPile.add(new Card(CardType.KNIGHT, 0));
            drawingPile.add(new Card(CardType.SLEEPING_POTION, 0));
        }
        for(int i  = 0; i < 3; i++){
            drawingPile.add(new Card(CardType.DRAGON, 0));
            drawingPile.add(new Card(CardType.MAGIC_WAND, 0));
        }
        for(int i = 1; i < 11; i++){
            for(int j = 0; j < 4; j++){
                drawingPile.add(new Card(CardType.NUMBER, i));
            }
        }
        Collections.shuffle(drawingPile);
    }

    public List<Card> discardAndDraw(List<Card> discard){

        discardedThisTurn.addAll(discard);
        List<Card> toDraw = new ArrayList<>();
        int discardAndDrawCount = discard.size();
        if(drawingPile.size() > discard.size()){
            for(int i = 0; i < discardAndDrawCount; i++){
                int toDrawAndRemove = drawingPile.size() -1;
                toDraw.add((drawingPile.get(toDrawAndRemove)));
                drawingPile.remove(toDrawAndRemove);
            }
            return toDraw;
        }
        return shuffleStrategy.shuffle(discard, drawingPile, thrashPile);
    }

    public void newTurn(){
        discardedThisTurn.clear();
    }

    public List<Card> getCardsDiscardedThisTurn(){
        return discardedThisTurn;
    }

    public List<Card> drawAtStart(){
        ArrayList<Card> toDraw = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int toDrawAndRemove = drawingPile.size()-1;
            toDraw.add(drawingPile.get(toDrawAndRemove));
            drawingPile.remove(toDrawAndRemove);
        }

        return toDraw;
    }



}
