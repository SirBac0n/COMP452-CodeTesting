import java.util.SortedMap;

public class StatsFileMock extends GameStats{
    private SortedMap<Integer, Integer> statsMap;

    public StatsFileMock(SortedMap<Integer, Integer> statsMap) {
        this.statsMap = statsMap;
    }

    @Override
    public int numGames(int numGuesses) {
        return statsMap.getOrDefault(numGuesses, 0);
    }

    @Override
    public int maxNumGuesses(){
        return (statsMap.isEmpty() ? 0 : statsMap.lastKey());
    }
}
