import java.util.*;

public class Game {

    private GameState gameState;

    private int onTurn;
    private  ArrayList<Player> players;

    private DrawingAndThrashPile drawingAndThrashPile;
    private SleepingQueens sleepingQueens;

    //1 game only one GameState... i guess
    public Game(int numberOfPlayers){
//        this.gameState = gameState;
//        this.players = new ArrayList<>();
//        for(int i = 0; i < gameState.numberOfPlayers; i++){
//            players.add(new Player(i));
//        }
//        sleepingQueens = new SleepingQueens();
        drawingAndThrashPile = new DrawingAndThrashPile();
        sleepingQueens = new SleepingQueens();
        for(int i = 0; i < numberOfPlayers; i++){
            players.add(new Player(i));
        }
        gameState = new GameState(numberOfPlayers, 0);


    }

    public GameState getGameState() {
        return gameState;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){
        players.get(playerIdx).play(cards);
        //update gamestate
        return Optional.empty();
    }
}
