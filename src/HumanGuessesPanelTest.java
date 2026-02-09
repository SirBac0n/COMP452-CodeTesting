import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanGuessesPanelTest {
    private HumanGuessesGame game;

    @BeforeEach
    void setup() {
        game = new HumanGuessesGame(480);
    }

    @Test
    void firstTry() {
        GuessResult result = game.makeGuess(480);
        assertEquals(GuessResult.CORRECT, result);
        assertEquals(1, game.getNumGuesses());
    }

    @Test
    void lowGuesses() {
        assertEquals(GuessResult.LOW, game.makeGuess(1));
        assertEquals(GuessResult.LOW, game.makeGuess(230));
        assertEquals(GuessResult.LOW, game.makeGuess(479));
        assertEquals(GuessResult.CORRECT, game.makeGuess(480));
        assertEquals(4, game.getNumGuesses());
    }

    @Test
    void highGuesses() {
        assertEquals(GuessResult.HIGH, game.makeGuess(999));
        assertEquals(GuessResult.HIGH, game.makeGuess(802));
        assertEquals(GuessResult.HIGH, game.makeGuess(803));
        assertEquals(GuessResult.HIGH, game.makeGuess(481));
        assertEquals(GuessResult.CORRECT, game.makeGuess(480));
        assertEquals(5, game.getNumGuesses());
    }


}
