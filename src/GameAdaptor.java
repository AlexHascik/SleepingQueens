public class GameAdaptor implements GamePlayerInterface {

    private String player;

    private Game game;
    //has access to the game
    private int cardPosition;
    public GameAdaptor(Game game){
        this.game = game;
    }


    @Override
    public String play(String player, String cards) {
        return convert(player, cards);
    }

    private String convert(String player, String cards){
        String str = "";
        for(int i =0; i < cards.length(); i++){
            if(Character.isDigit(cards.charAt(i))){
                str += cards.charAt(i);
            }
        }
        return str;
    }
}
