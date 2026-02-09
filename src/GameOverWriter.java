import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import com.opencsv.CSVWriter;

public class GameOverWriter {
    public static void writeGameResults(GameResult result, CSVWriter writer) {
        // write stats to file

        String [] record = new String[2];
        record[0] = LocalDateTime.now().toString();
        record[1] = Integer.toString(result.numGuesses);

        writer.writeNext(record);
    }

    public static void writeGameResults(GameResult result) {
        try(CSVWriter writer = new CSVWriter(new FileWriter(StatsFile.FILENAME, true))) {
            writeGameResults(result, writer);
        } catch (IOException e) {
            // NOTE: In a full implementation, we would log this error and possibly alert the user
            // NOTE: For this project, you do not need unit tests for handling this exception.
        }
    }
}
