import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverWriterTest {

    @Test
    void setGameResults() {
        WriterMock writer = new WriterMock();
        CSVWriterMock csv = new CSVWriterMock(writer);
        GameResult gr = new GameResult(true, 500, 1);
        LocalDateTime date = LocalDateTime.now();
        GameOverWriter.writeGameResults(gr, csv, date);
        assertEquals(1, csv.lines.size());
        assertEquals("1", csv.lines.getFirst()[1]);
        assertEquals(date.toString(), csv.lines.getFirst()[0]);
    }

    @Test
    void setMultipleGameResults() {
        WriterMock writer = new WriterMock();
        CSVWriterMock csv = new CSVWriterMock(writer);
        GameResult gr = new GameResult(true, 480, 1);
        LocalDateTime firstTime = LocalDateTime.now();
        GameOverWriter.writeGameResults(gr, csv, firstTime);
        gr = new GameResult(true, 89, 4);
        LocalDateTime secondTime = LocalDateTime.now();
        GameOverWriter.writeGameResults(gr, csv, secondTime);
        assertEquals(2, csv.lines.size());
        assertEquals("1", csv.lines.getFirst()[1]);
        assertEquals(firstTime.toString(), csv.lines.getFirst()[0]);
        assertEquals(secondTime.toString(), csv.lines.getLast()[0]);
    }
}
