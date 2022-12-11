import java.util.List;

public interface ShuffleStrategy {

    public List<Card> shuffle(List<Card> discard, List<Card> drawingPile, List<Card> thrashPile);
    public List<Card> getThrashPile();
    public List<Card> getDrawingPile();
}
