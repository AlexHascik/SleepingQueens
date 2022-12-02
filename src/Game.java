import java.util.*;

public class Game {

    private GameState gameState;
    private final ArrayList<Player> players;

    private DrawingAndThrashPile drawingAndThrashPile;

    private SleepingQueens sleepingQueens;

    //1 game only one GameState... i guess
    public Game(GameState gameState){
        this.gameState = gameState;
        this.players = new ArrayList<>();
        //Upon creating game add n players
        for(int i = 0; i < gameState.numberOfPlayers; i++){
            players.add(new Player());
        }


    }

    public GameState getGameState() {
        return gameState;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){
        players.get(playerIdx).play(cards);
        return Optional.empty();
    }
}
