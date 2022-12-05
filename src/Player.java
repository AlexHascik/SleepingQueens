import java.util.*;

public class Player {

    private PlayerState playerState;
    private int playerIdx;
    private EvaluateNumberedCards numberedCards = new EvaluateNumberedCards();
    private MoveQueen moveQueen = new MoveQueen();

    private AwokenQueens awokenQueens;


    private Hand hand;
    public Player(int playerIdx){
        playerState = new PlayerState();
        hand = new Hand(playerIdx);
        this.playerIdx = playerIdx;
        awokenQueens = new AwokenQueens(this);
    }
    public void play(List<Position> cards){

        // mozno evaluatnut karty, mame pocitat ze hrac zada dobre karty... ?

        ArrayList<Card> selectedCards = new ArrayList<>();
        Map<Integer, Optional<Card>> playerCards = playerState.getCards();
            Position cardPosition = cards.get(0);
            if(cardPosition instanceof HandPosition){
                Card toBePlayed = playerCards.get(((HandPosition) cardPosition).getCardIndex()).get();
                switch (toBePlayed.getCardType()){
                    case KNIGHT:
                        EvaluateAttack evaluateKnight = new EvaluateAttack(CardType.DRAGON);
                        AwokenQueenPosition queen = (AwokenQueenPosition) cards.get(1);
                        if(evaluateKnight.play(queen, queen.getPlayerIndex())){
                            //consume cards
                        }
                        break;
                    case SLEEPING_POTION:
                        EvaluateAttack evaluateMagicWand = new EvaluateAttack(CardType.MAGIC_WAND);
                        AwokenQueenPosition queenToSleep = (AwokenQueenPosition) cards.get(1);
                        if(evaluateMagicWand.play(queenToSleep, queenToSleep.getPlayerIndex())) {
                            //consume cards
                        }
                        break;
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

    public int getPlayerIdx() {
        return playerIdx;
    }
}
