import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerGuessesPanelTest {

    private ComputerGuessesPanel cgp;

    @BeforeEach
    void setup() {
        cgp = new ComputerGuessesPanel();
    }

    @Test
    void defaultVals() {
        int lowerBound = cgp.getLowerBound();
        int upperBound = cgp.getUpperBound();
        int numGuesses = cgp.getNumGuesses();
        int lastGuess = cgp.getLastGuess();
        assertEquals(1, lowerBound);
        assertEquals(1000, upperBound);
        assertEquals(1, numGuesses);
        assertEquals(500, lastGuess);
    }

    @Test
    void getNextGuess() {
        int guess = cgp.getNextGuess(1000, 1);
        int expected = (1 + 1000) / 2;
        assertEquals(expected, guess);
    }

    @Test
    void higherGuess() {
        cgp.higherGuess();
        int lowerBound = cgp.getLowerBound();
        int lastGuess = cgp.getLastGuess();
        int numGuesses = cgp.getNumGuesses();
        assertEquals(501, lowerBound);
        int expectedGuess = (501 + 1000) / 2;
        assertEquals(expectedGuess, lastGuess);
        assertEquals(2, numGuesses);
    }

    @Test
    void lowerGuess() {
        cgp.lowerGuess();
        int upperBound = cgp.getUpperBound();
        int lastGuess = cgp.getLastGuess();
        int numGuesses = cgp.getNumGuesses();
        assertEquals(499, upperBound);
        int expectedGuess = (1 + 499) / 2;
        assertEquals(expectedGuess, lastGuess);
        assertEquals(2, numGuesses);
    }
}
