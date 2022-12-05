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
        for (String s : c) {
            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'h':
                        j += 1;
                        cardsToSend.add(new HandPosition(Integer.valueOf(s.charAt(j)), players.get(player)));
                    case 'a':
                        j+=1;
                        cardsToSend.add(new AwokenQueenPosition(Integer.valueOf(s.charAt(j++)), Integer.valueOf(s.charAt(j))));
                    case 's':
                        //ako sa dostat nakoniec aby to nespadlo
                        j+=1;
                        cardsToSend.add(new SleepingQueenPosition(Integer.parseInt(s.substring(1))));
                }
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
