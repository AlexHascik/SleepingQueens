public class EvaluateAttack {

    private CardType defenseCardType;
    private MoveQueen moveQueen;

    public EvaluateAttack(CardType defenseCardType){
        this.defenseCardType = defenseCardType;
        this.moveQueen = new MoveQueen();
    }
    public boolean play(Position targetQueen, int targetPlayerIdx){
        if(!(targetQueen instanceof AwokenQueenPosition)) { return false;}
        AwokenQueenPosition target = (AwokenQueenPosition) targetQueen;
        if(!(target.getPlayerIndex() == targetPlayerIdx)){ return false;}

        moveQueen.play(targetQueen);


        return true;
    }
}
