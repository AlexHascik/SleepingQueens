import java.util.*;

public class ShuffleStrategyA implements ShuffleStrategy{

    private ArrayList<Card> thrashPile;
    private ArrayList<Card> drawingPile;

    public ShuffleStrategyA(){
        thrashPile = new ArrayList<>();
        drawingPile = new ArrayList<>();
    }
    @Override
    public List<Card> shuffle(List<Card> discard, List<Card> drawingPile, List<Card> thrashPile){
        this.thrashPile.addAll(thrashPile);
        this.drawingPile.addAll(drawingPile);
        ArrayList<Card> toDraw = new ArrayList<>();
        thrashPile.addAll(discard);
        int alreadyDrawn = 0;
        for(int i = 0; i < drawingPile.size(); i++){
            int toDrawAndRemove = drawingPile.size()-1;
            toDraw.add(drawingPile.get(toDrawAndRemove));
            alreadyDrawn++;
        }
        drawingPile.clear();
        Collections.shuffle(thrashPile);
        drawingPile.addAll(thrashPile);
        thrashPile.clear();
        for(int i = 0; i < alreadyDrawn; i++){
            int toDrawAndRemove = drawingPile.size()-1;
            toDraw.add(drawingPile.get(toDrawAndRemove));
            drawingPile.remove(toDrawAndRemove);
        }
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
