import java.util.Map;

public class SleepingQueens extends QueenCollection{

    public SleepingQueens(){
        for(int i = 0; i < 12; i++){
            super.addQueen(new Queen(10));
        }
    }
}
