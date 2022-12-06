import java.util.*;

public class Game {

    private GameState gameState;
    private int onTurn;
    private  ArrayList<Player> players;
    private DrawingAndThrashPile drawingAndThrashPile;
    private SleepingQueens sleepingQueens;

    public Game(int numberOfPlayers){

        drawingAndThrashPile = new DrawingAndThrashPile();
        sleepingQueens = new SleepingQueens();
        for(int i = 0; i < numberOfPlayers; i++){
            players.add(new Player(i));
        }
        gameState = new GameState(numberOfPlayers, 0);

    }

    public void nextTurn(GameState gameState){
        gameState.onTurn = (gameState.onTurn + 1) % players.size();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){

        players.get(playerIdx).play(cards);
        return Optional.empty();
    }
}
