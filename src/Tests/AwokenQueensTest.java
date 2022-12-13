import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AwokenQueensTest {


    @Test
    public void awokenQueensTest(){
        AwokenQueens awokenQueens = new AwokenQueens(0);

        assertEquals(Optional.empty(),awokenQueens.removeQueen(new AwokenQueenPosition(0, 0)));

        awokenQueens.addQueen(new Queen(5));
        awokenQueens.addQueen(new Queen(10));
        awokenQueens.removeQueen(new AwokenQueenPosition(0,0));
        assertEquals(1, awokenQueens.getQueens().size());

    }

}