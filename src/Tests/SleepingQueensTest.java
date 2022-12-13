import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SleepingQueensTest {

    @Test
    public void sleepingQueensTest(){
        SleepingQueens sleepingQueens = new SleepingQueens();
        sleepingQueens.removeQueen(new SleepingQueenPosition(0));
        assertEquals(11, sleepingQueens.getQueens().size());

        assertEquals(Optional.empty(), sleepingQueens.removeQueen(new SleepingQueenPosition(0)));
        sleepingQueens.addQueen(new Queen(5));
        assertEquals(12 , sleepingQueens.getQueens().size());
    }

}