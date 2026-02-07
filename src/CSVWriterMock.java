import com.opencsv.CSVWriter;

import java.io.Writer;
import java.util.ArrayList;

public class CSVWriterMock extends CSVWriter {
    public ArrayList<String[]> lines;

    public CSVWriterMock(Writer writer) {
        super(writer);
        lines = new ArrayList<>();
    }

    @Override
    public void writeNext(String[] nextLine) {
        lines.add(nextLine);
    }
}
