import java.util.ArrayList;
import java.util.Map;

public class GameAdaptor implements GamePlayerInterface {

    private String player;
    private Game game;
    private ArrayList<Position> cardsToSend;
    private Map<String, Integer> players;

    public GameAdaptor(){

//        this.game = game;
//        game = new Game();

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

        return "Turn executed";
    }

//    private String convert(String player, String cards){
//        String str = "";
//        for(int i =0; i < cards.length(); i++){
//            if(Character.isDigit(cards.charAt(i))){
//                str += cards.charAt(i);
//            }
//        }
//        return str;
//    }
}
