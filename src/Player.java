import java.util.*;

public class Player {

    private PlayerState playerState;
    private int playerIdx;
    private EvaluateNumberedCards numberedCards = new EvaluateNumberedCards();
    private MoveQueen moveQueen = new MoveQueen();


    private Hand hand;
    public Player(int playerIdx){
        playerState = new PlayerState();
        hand = new Hand(playerIdx);
    }
    public void play(List<Position> cards){
        ArrayList<Card> selectedCards = new ArrayList<>();
        Map<Integer, Optional<Card>> playerCards = playerState.getCards();
            Position cardPosition = cards.get(0);
            if(cardPosition instanceof HandPosition){
                Card toBePlayed = playerCards.get(((HandPosition) cardPosition).getCardIndex()).get();
                switch (toBePlayed.getCardType()){
                    case KNIGHT: EvaluateAttack evaluateKnight = new EvaluateAttack(CardType.DRAGON);
                        AwokenQueenPosition queen = (AwokenQueenPosition) cards.get(2);
                        if(evaluateKnight.play(cards.get(2), queen.getPlayerIndex())){
                            //consume cards
                        }
                    case SLEEPING_POTION: EvaluateAttack evaluateMagicWand = new EvaluateAttack(CardType.MAGIC_WAND);
                        AwokenQueenPosition queenToSleep = (AwokenQueenPosition) cards.get(2);
                        if(evaluateMagicWand.play(cards.get(2), queenToSleep.getPlayerIndex())) {
                            //consume cards
                        }
                    case NUMBER:

                        if(numberedCards.play(hand.getCards())){
                            //consume cards
                        }
                    case KING:
                        moveQueen.play(cards.get(1));

                }
            }


    }

    public PlayerState getPlayerState(){
        return playerState;
    }

}
