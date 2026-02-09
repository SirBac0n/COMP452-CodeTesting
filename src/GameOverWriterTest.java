import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverWriterTest {

    @Test
    void setGameResults() {
        GameOverPanel gop = new GameOverPanel(new JPanel());
        WriterMock writer = new WriterMock();
        CSVWriterMock csv = new CSVWriterMock(writer);
        GameResult gr = new GameResult(true, 500, 1);
        GameOverWriter.writeGameResults(gr, csv);
        assertEquals(1, csv.lines.size());
        assertEquals("1", csv.lines.getFirst()[1]);
    }
}
