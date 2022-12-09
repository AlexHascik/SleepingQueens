import java.util.List;

public class EvaluateNumberedCards {


    public boolean play(List<Card> cards){

        if(cards.size() == 1){ return true;}

        int lastCardNumber = cards.get(cards.size()-1).getValue();
        int sum = 0;
        for(int i = 0; i < cards.size() - 1; i++){
            if(cards.get(i).getCardType() != CardType.NUMBER ){ return false;}
            sum += cards.get(i).getValue();
        }

        return sum == lastCardNumber;
    }
}
