import java.util.Objects;

public class AwokenQueenPosition implements Position {

    private int cardIndex;
    private  int playerIndex;


    public AwokenQueenPosition(int cardIndex, int playerIndex){
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;
    }

    @Override
    public int getCardIndex() {
        return cardIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwokenQueenPosition that = (AwokenQueenPosition) o;
        return cardIndex == that.cardIndex && playerIndex == that.playerIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardIndex, playerIndex);
    }
}
