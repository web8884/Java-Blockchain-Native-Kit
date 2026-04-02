import java.util.List;

public class ChainValidator {
    public boolean validate(List<BlockHeader> chain) {
        if (chain.isEmpty()) return true;
        if (!chain.get(0).prevHash.equals("0")) return false;

        for (int i = 1; i < chain.size(); i++) {
            BlockHeader curr = chain.get(i);
            BlockHeader prev = chain.get(i - 1);
            if (!curr.prevHash.equals(prev.hash)) return false;
            if (!curr.hash.equals(curr.computeHash())) return false;
        }
        return true;
    }
}
