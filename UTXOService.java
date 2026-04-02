import java.util.*;

public class UTXOService {
    private final Map<String, Double> utxoMap = new HashMap<>();

    public void addUTXO(String address, double value) {
        utxoMap.put(address, utxoMap.getOrDefault(address, 0.0) + value);
    }

    public boolean spendUTXO(String from, double amount) {
        double balance = utxoMap.getOrDefault(from, 0.0);
        if (balance < amount) return false;
        utxoMap.put(from, balance - amount);
        return true;
    }

    public double getBalance(String address) {
        return utxoMap.getOrDefault(address, 0.0);
    }
}
