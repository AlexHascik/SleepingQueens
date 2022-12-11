import java.util.*;

public class Game {

    private GameState gameState;

    private int onTurn;
    private  ArrayList<Player> players;
    private DrawingAndThrashPile drawingAndThrashPile;
    private SleepingQueens sleepingQueens;

    private final GameFinishedStrategy gameFinished;
    public Game(int numberOfPlayers){

        drawingAndThrashPile = new DrawingAndThrashPile();
        sleepingQueens = new SleepingQueens();
        players = new ArrayList<>();



        //vytvorime handy pre hracov, pridame referencie na discardandthrashpile, nasledne vytvorime hracov
        Map<Integer, Hand> playerHands = new HashMap<>();
        Map<Integer, AwokenQueens> playerAwokenQueens = new HashMap<>();
        for(int i = 0; i < numberOfPlayers; i++){
            Hand hand = new Hand(i, drawingAndThrashPile);
            AwokenQueens awokenQueens = new AwokenQueens(i);
            playerHands.put(i, hand);
            playerAwokenQueens.put(i, awokenQueens);
            MoveQueen moveQueen = new MoveQueen(playerHands, sleepingQueens, playerAwokenQueens);
            EvaluateAttack evaluateAttack = new EvaluateAttack(CardType.DRAGON, playerHands, moveQueen);

            players.add(new Player(i, hand, evaluateAttack, moveQueen, awokenQueens));
        }

        gameState = new GameState(numberOfPlayers, 0);
        //rozdanie 5 kariet kazdemu hracovi a priradenie do gamestateu
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
        gameState.setCards(cards);
        updateGameState();

        gameFinished = new GameFinished(playerAwokenQueens, numberOfPlayers);




    }

    public void nextTurn(GameState gameState){
        gameState.setOnTurn((gameState.getOnTurn() +1 ) % players.size());
    }

    public GameState getGameState() {
        return gameState;
    }

    public Optional<GameState> play(int playerIdx, List<Position> cards){

        if(players.get(playerIdx).play(cards)){
            gameState.setOnTurn((gameState.getOnTurn() + 1) % players.size());
            updateGameState();
            Optional<Integer> winner = gameFinished.isFinished();
            if(winner.isPresent()){
                gameState.setOnTurn(-1);
                System.out.println("Player " + winner.get() + "won");
            }
        } else{
            System.out.println("Try again");
        }

        return Optional.ofNullable(gameState);
    }

    private void updateGameState(){
        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        for(Position sleepingPosition : sleepingQueens.getQueens().keySet()){
            sleepingQueenPositions.add((SleepingQueenPosition) sleepingPosition);
        }
        gameState.setSleepingQueens(sleepingQueenPositions);

        Map<HandPosition, Optional<Card>> playerCards = new HashMap<>();
        for(Player player : players){
            for(Map.Entry<Integer, Optional<Card>> entry : player.getPlayerState().getCards().entrySet()){
                playerCards.put(new HandPosition(entry.getKey(), player.getPlayerIdx()), entry.getValue());
            }
        }
        gameState.setCards(playerCards);

        Map<AwokenQueenPosition, Queen> playerAwokenQueens = new HashMap<>();
        for(Player player : players){
            for(Map.Entry<Integer, Queen> entry : player.getPlayerState().getAwokenQueens().entrySet()){
                playerAwokenQueens.put(new AwokenQueenPosition(entry.getKey(), player.getPlayerIdx()), entry.getValue());
            }
        }
        gameState.setAwokenQueens(playerAwokenQueens);





    }
    public ArrayList<Player> getPlayers(){
        return players;
    }

}
