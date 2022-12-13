import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawingAndThrashPileTest {

    private DrawingAndThrashPile drawingAndThrashPile;

    void setUp(){
        drawingAndThrashPile = new DrawingAndThrashPile();
    }

    @Test
    void drawCardsTest(){
        setUp();
        List<Card> cardList = drawingAndThrashPile.drawAtStart();
        assertEquals(5, cardList.size());
        cardList.remove(4);
        List<Card> toDraw = drawingAndThrashPile.discardAndDraw(cardList);
        assertEquals(4, toDraw.size());

        ArrayList<Card> empty = new ArrayList<>();
        assertEquals(0, drawingAndThrashPile.discardAndDraw(empty).size());
    }

    @Test
    void discardTest(){
        setUp();
        List<Card> cardList = drawingAndThrashPile.drawAtStart();
        cardList.remove(0);
        drawingAndThrashPile.discardAndDraw(cardList);
        assertEquals(cardList, drawingAndThrashPile.getCardsDiscardedThisTurn());
    }
}