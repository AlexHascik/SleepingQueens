public class SleepingQueenPosition implements Position {

    private int cardIndex;

    public SleepingQueenPosition(int cardIndex){
        this.cardIndex = cardIndex;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    @Override
    public String toString(){
        return String.valueOf(cardIndex) ;
    }
}
