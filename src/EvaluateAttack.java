import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EvaluateAttack {

    private CardType defenseCardType;
    private MoveQueen moveQueen;

    private Map<Integer, Hand> playerHands;

    public EvaluateAttack(CardType defenseCardType, Map<Integer, Hand> playerHands, MoveQueen moveQueen){
        this.defenseCardType = defenseCardType;
        this.moveQueen = moveQueen;
        this.playerHands = playerHands;

    }
    public boolean play(Position targetQueen, int targetPlayerIdx, int playerIdx){
        if(!(targetQueen instanceof AwokenQueenPosition)) { return false;}
        AwokenQueenPosition target = (AwokenQueenPosition) targetQueen;
        if(!(target.getPlayerIndex() == targetPlayerIdx)){ return false;}

        HandPosition defenseCardPos = playerHands.get(targetPlayerIdx).hasCardOfType(defenseCardType);
        if(defenseCardPos != null){
            ArrayList<HandPosition> positions = new ArrayList<>();
            positions.add(defenseCardPos);
            playerHands.get(targetPlayerIdx).pickCards(positions);
            playerHands.get(targetPlayerIdx).removePickedCardsAndRedraw();
        } else{
            moveQueen.play(targetQueen,playerIdx );
        }
        return true;
    }

    public void setDefenseCardType(CardType defenseCardType){
        this.defenseCardType = defenseCardType;
    }
}
