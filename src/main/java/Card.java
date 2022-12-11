public class Card {

    private CardType cardType;
    private int value;

    public Card(CardType cardType, int value){
        this.cardType = cardType;
        this.value = value;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString(){
        return cardType + " value: " + String.valueOf(value);
    }
}
