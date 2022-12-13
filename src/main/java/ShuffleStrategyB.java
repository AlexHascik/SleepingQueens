import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleStrategyB implements ShuffleStrategy{

    private ArrayList<Card> thrashPile;
    private ArrayList<Card> drawingPile;

    public ShuffleStrategyB(){
        thrashPile = new ArrayList<>();
        drawingPile = new ArrayList<>();
    }

    @Override
    public List<Card> shuffle(List<Card> discard, List<Card> drawingPile, List<Card> thrashPile) {
        this.thrashPile.addAll(thrashPile);
        this.drawingPile.addAll(drawingPile);
        ArrayList<Card> toDraw = new ArrayList<>();
        Collections.shuffle(thrashPile);
        ArrayList<Card> newDrawingPile = new ArrayList<>(thrashPile);
        newDrawingPile.addAll(drawingPile);
        thrashPile.clear();
        for(int i = 0; i < discard.size(); i++){
            int toDrawAndRemove = newDrawingPile.size() - 1;
            toDraw.add(newDrawingPile.get(toDrawAndRemove));
            newDrawingPile.remove(toDrawAndRemove);
        }
        drawingPile.clear();
        drawingPile.addAll(newDrawingPile);
        return toDraw;
    }

    @Override
    public List<Card> getThrashPile() {
        return thrashPile;
    }

    @Override
    public List<Card> getDrawingPile() {
        return drawingPile;
    }
}
