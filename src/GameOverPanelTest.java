import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.FileWriter;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverPanelTest {

    @Test
    void setGameResults() {
        GameOverPanel gop = new GameOverPanel(new JPanel());
        WriterMock writer = new WriterMock();
        CSVWriterMock csv = new CSVWriterMock(writer);
        GameResult gr = new GameResult(true, 500, 1);
        gop.setGameResults(gr, csv);
        assertEquals(1, csv.lines.size());
        assertEquals("1", csv.lines.getFirst()[1]);
    }
}
