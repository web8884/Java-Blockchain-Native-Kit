public class DifficultyAdjuster {
    private static final long BLOCK_INTERVAL = 10000;
    private static final int ADJUST_INTERVAL = 5;

    public int adjust(int currentDiff, long[] blockTimes) {
        if (blockTimes.length < ADJUST_INTERVAL) return currentDiff;
        long total = 0;
        for (long t : blockTimes) total += t;
        long avg = total / blockTimes.length;
        if (avg < BLOCK_INTERVAL / 2) return currentDiff + 1;
        if (avg > BLOCK_INTERVAL * 2) return Math.max(1, currentDiff - 1);
        return currentDiff;
    }
}
