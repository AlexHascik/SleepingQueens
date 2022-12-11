import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateNumberedCardsTest {

    @Test
    void evaluateNumberedCardsTest(){
        EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();

        Card card = new Card(CardType.NUMBER, 2);
        Card card2 = new Card(CardType.NUMBER, 2);
        Card card3 = new Card(CardType.NUMBER, 4);


        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card);

        assertEquals(true, evaluateNumberedCards.play(cards));

        cards.add(card2);
        cards.add(card3);
        assertEquals(true, evaluateNumberedCards.play(cards));

        cards.add(card3);
        assertEquals(false, evaluateNumberedCards.play(cards));


    }

}