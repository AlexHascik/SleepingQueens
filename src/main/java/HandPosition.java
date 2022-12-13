import java.util.Objects;

public class HandPosition implements Position{

    private int cardIndex;
    private int playerIndex;

    public HandPosition(int cardIndex, int playerIndex){
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
        HandPosition that = (HandPosition) o;
        return cardIndex == that.cardIndex && playerIndex == that.playerIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardIndex, playerIndex);
    }

    @Override
    public String toString(){
        return "Player: " +  String.valueOf(playerIndex) + " Index: " + String.valueOf(cardIndex) + " ";
    }
}
