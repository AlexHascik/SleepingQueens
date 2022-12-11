import java.util.ArrayList;
import java.util.Map;

public class GameAdaptor implements GamePlayerInterface {

    private String player;
    private Game game;
    private ArrayList<Position> cardsToSend;
    private Map<String, Integer> players;

    private GameObservable gameObservable;
    public GameAdaptor(GameObservable gameObservable){

        if(gameObservable.getPlayerCount() < 2){
            System.out.println("You need at least 2 players to play. Game was not created.");
        } else{
            this.gameObservable = gameObservable;
            game = new Game(gameObservable.getPlayerCount());
        }

    }



    @Override
    public String play(String player, String cards) {
        String [] c = cards.split(" ");
        cardsToSend = new ArrayList<>();

        for(String command : cards.split(" ")){
            int firstCardPosition = Integer.valueOf(command.charAt(1));
            switch(command.charAt(0)){
                case 'h': cardsToSend.add(new HandPosition(firstCardPosition,players.get(player)));
                case 'a': cardsToSend.add(new AwokenQueenPosition(Integer.valueOf(command.charAt(2)), players.get(player)));
                case 's': cardsToSend.add(new SleepingQueenPosition(Integer.parseInt(command.substring(1))));
            }
        }

        game.play(players.get(player), cardsToSend);

        return "Cards played";
    }


}
