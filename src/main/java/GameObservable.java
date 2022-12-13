import java.util.ArrayList;
import java.util.List;

public class GameObservable {
    private List<GameObserver> gameObservers;
    private List<String> playerNames;
    public GameObservable(){
        gameObservers = new ArrayList<>();
        playerNames= new ArrayList<>();
    }
    public void add (GameObserver observer){
        gameObservers.add(observer);
    };
    public void addPlayer(String name, GameObserver observer){
        if(playerNames.size() < 5 && !playerNames.contains(name)){
            playerNames.add(name);
            gameObservers.add(observer);
        }
    };
    public void remove(GameObserver observer){
        try{
            gameObservers.remove(observer);
        } catch(Exception e){
            System.err.println("Observer " + observer.toString() + "does not exists.");
        }
    };
    public void notifyAll(GameState message){
        for(GameObserver observer : gameObservers){
            observer.notify(message.toString());
        }
    };

    public List<String> getPlayerNames(){
        return playerNames;
    }

    public int getPlayerCount(){
        return playerNames.size();
    }


}
