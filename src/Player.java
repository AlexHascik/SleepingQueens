import java.util.*;

public class Player {

    private PlayerState playerState;
    private int playerIdx;
    private EvaluateNumberedCards numberedCards = new EvaluateNumberedCards();
    private MoveQueen moveQueen;

    private AwokenQueens awokenQueens;

    private EvaluateAttack evaluateAttack;
    private Hand hand;
    public Player(int playerIdx, Hand hand, EvaluateAttack evaluateAttack, MoveQueen moveQueen){
        playerState = new PlayerState();
        this.hand = hand;
        this.playerIdx = playerIdx;
        awokenQueens = new AwokenQueens(this);
        this.evaluateAttack =evaluateAttack;
        this.moveQueen = moveQueen;
    }
    public void play(List<Position> cards){


        ArrayList<HandPosition> selectedCards = new ArrayList<>();
        Map<Integer, Optional<Card>> playerCards = playerState.getCards();
            Position cardPosition = cards.get(0);
            if(cardPosition instanceof HandPosition){
                Card toBePlayed = playerCards.get(((HandPosition) cardPosition).getCardIndex()).get();
                switch (toBePlayed.getCardType()){
                    case KNIGHT:
                        evaluateAttack.setDefenseCardType(CardType.DRAGON);
                        AwokenQueenPosition queen = (AwokenQueenPosition) cards.get(1);
                        if(evaluateAttack.play(queen, queen.getPlayerIndex(), playerIdx)){
                            //consume cards
                            selectedCards.add((HandPosition) cards.get(0));
                            hand.pickCards(selectedCards);
                            hand.removePickedCardsAndRedraw();
                        }
                        break;
                    case SLEEPING_POTION:
                        evaluateAttack.setDefenseCardType(CardType.MAGIC_WAND);
                        AwokenQueenPosition queenToSleep = (AwokenQueenPosition) cards.get(1);
                        if(evaluateAttack.play(queenToSleep, queenToSleep.getPlayerIndex(), playerIdx)) {
                            //consume cards
                            selectedCards.add((HandPosition) cards.get(0));
                            hand.pickCards(selectedCards);
                            hand.removePickedCardsAndRedraw();
                        }
                        break;
                    case NUMBER:

                        if(numberedCards.play(hand.getCards())){
                            //consume cards
                            for(Position position : cards){
                               selectedCards.add((HandPosition) position);
                               hand.pickCards(selectedCards);
                               hand.removePickedCardsAndRedraw();
                            }

                        }
                    case KING:
                        moveQueen.play(cards.get(1), playerIdx);

                }
            }


    }

    public PlayerState getPlayerState(){
        return playerState;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }
}
