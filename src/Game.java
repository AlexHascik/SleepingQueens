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
        players = new ArrayList<>();



        //vytvorime handy pre hracov, pridame referencie na discardandthrashpile, nasledne vytvorime hracov
        Map<Integer, Hand> playerHands = new HashMap<>();
        for(int i = 0; i < numberOfPlayers; i++){
            Hand hand = new Hand(i,drawingAndThrashPile);
            playerHands.put(i, hand);
            MoveQueen moveQueen = new MoveQueen(playerHands, sleepingQueens);
            EvaluateAttack evaluateAttack = new EvaluateAttack(CardType.DRAGON, playerHands, moveQueen);
            players.add(new Player(i, hand, evaluateAttack, moveQueen));
        }

        gameState = new GameState(numberOfPlayers, 0);
        //pridanie sleepingqueensposition do gamestateu
        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        for(Position sleepingPosition : sleepingQueens.getQueens().keySet()){
            sleepingQueenPositions.add((SleepingQueenPosition) sleepingPosition);
        }
        gameState.setSleepingQueens(sleepingQueenPositions);
        //pridanie kariet hracov do gamestateu a playerstateu
        Map<HandPosition, Optional<Card>> cards = new HashMap<>();
        Map<Integer, Optional<Card>> playerCards = new HashMap<>();
        for(Player player : players){
            List<Card> toDraw = drawingAndThrashPile.drawAtStart();
            for(int i = 0; i < 5; i++){
                cards.put(new HandPosition(i, player.getPlayerIdx()), Optional.ofNullable(toDraw.get(i)));
                playerCards.put(i, Optional.ofNullable(toDraw.get(i)));
            }
            player.getPlayerState().setCards(playerCards);
        }



    }

    public void nextTurn(GameState gameState){
//        gameState.onTurn = (gameState.onTurn + 1) % players.size();
        gameState.setOnTurn((gameState.getOnTurn() +1 ) % players.size());
    }

    public GameState getGameState() {
        return gameState;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){

        players.get(playerIdx).play(cards);
        updateGameState();
        return Optional.ofNullable(gameState);
    }

    private void updateGameState(){

    }
}
