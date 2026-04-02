import java.util.HashMap;
import java.util.Map;

public class MiniTokenSystem {
    public static final String NAME = "JavaNativeToken";
    public static final String SYMBOL = "JNT";
    public static final double TOTAL = 21_000_000;

    private final Map<String, Double> balances = new HashMap<>();

    public MiniTokenSystem() {
        balances.put("GENESIS_ADDRESS", TOTAL);
    }

    public boolean transfer(String from, String to, double amt) {
        if (balances.getOrDefault(from, 0.0) < amt || amt <= 0) return false;
        balances.put(from, balances.get(from) - amt);
        balances.put(to, balances.getOrDefault(to, 0.0) + amt);
        return true;
    }

    public double balance(String addr) {
        return balances.getOrDefault(addr, 0.0);
    }
}
