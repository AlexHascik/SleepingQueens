import java.util.List;

public class Player {

    private PlayerState playerState;
    public Player(){
        playerState = new PlayerState();
    }
    public void play(List<Position> cards){

    }

    public PlayerState getPlayerState(){
        return playerState;
    }
}
