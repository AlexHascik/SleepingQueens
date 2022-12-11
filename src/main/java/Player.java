import java.util.*;

public class Player {

    private PlayerState playerState;
    private int playerIdx;
    private EvaluateNumberedCards numberedCards = new EvaluateNumberedCards();
    private MoveQueen moveQueen;

    private AwokenQueens awokenQueens;

    private EvaluateAttack evaluateAttack;
    private Hand hand;

    public Player(int playerIdx, Hand hand, EvaluateAttack evaluateAttack, MoveQueen moveQueen, AwokenQueens awokenQueens) {
        playerState = new PlayerState();
        this.hand = hand;
        this.playerIdx = playerIdx;
        this.awokenQueens = awokenQueens;
        this.evaluateAttack = evaluateAttack;
        this.moveQueen = moveQueen;
    }

    public boolean play(List<Position> cards) {

        if (cards.isEmpty()) {
            System.out.println("Choose a card you wish to play");
            return false;
        }
        if (!(cards.get(0) instanceof HandPosition)) {
            System.out.println("Choose a card from your hand");
            return false;
        }

        ArrayList<HandPosition> selectedCards = new ArrayList<>();
        Map<Integer, Optional<Card>> playerCards = playerState.getCards();
        Position cardPosition = cards.get(0);

        Optional<Card> toBePlayed = playerCards.get(((HandPosition) cardPosition).getCardIndex());
        if (toBePlayed.isEmpty()) {
            System.out.println("Choose one of your 5 cards");
            return false;
        }
        switch (toBePlayed.get().getCardType()) {
            case KNIGHT:

                if(!(cards.get(1) instanceof AwokenQueenPosition)){ return false;}
                evaluateAttack.setDefenseCardType(CardType.DRAGON);
                AwokenQueenPosition queen = (AwokenQueenPosition) cards.get(1);

                    if (evaluateAttack.play(queen, queen.getPlayerIndex(), playerIdx)) {
                    selectedCards.add((HandPosition) cards.get(0));
//                           hand.pickCards(selectedCards);
//                           hand.removePickedCardsAndRedraw();
                } else{
                    return false;
                }
                break;
            case SLEEPING_POTION:
                if(!(cards.get(1) instanceof AwokenQueenPosition)){ return false;}
                evaluateAttack.setDefenseCardType(CardType.MAGIC_WAND);
                AwokenQueenPosition queenToSleep = (AwokenQueenPosition) cards.get(1);
                if (evaluateAttack.play(queenToSleep, queenToSleep.getPlayerIndex(), playerIdx)) {
                    selectedCards.add((HandPosition) cards.get(0));

                } else{
                    return false;
                }
                break;
            case NUMBER:

                if (numberedCards.play(hand.getCards())) {
                    for (Position position : cards) {
                        selectedCards.add((HandPosition) position);
                    }


                }else{
                    return false;
                }
            case KING:
                if(!(cards.get(1) instanceof SleepingQueenPosition)){ return false;}
                if(moveQueen.play(cards.get(1), playerIdx)){
                    selectedCards.add((HandPosition) cards.get(1));
                } else{
                    return false;
                }

                break;

        }

        pickAndRemove(hand, selectedCards);
        return true;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    private void pickAndRemove(Hand hand, List<HandPosition> selectedCards) {
        hand.pickCards(selectedCards);
        hand.removePickedCardsAndRedraw();
    }
}
