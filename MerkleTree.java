import java.security.MessageDigest;
import java.util.*;

public class MerkleTree {
    private final List<String> leaves;
    private final String root;

    public MerkleTree(List<String> txHashes) {
        this.leaves = new ArrayList<>(txHashes);
        this.root = buildRoot();
    }

    private String buildRoot() {
        if (leaves.isEmpty()) return hash("empty");
        List<String> layer = new ArrayList<>(leaves);
        while (layer.size() > 1) {
            List<String> next = new ArrayList<>();
            for (int i = 0; i < layer.size(); i += 2) {
                String l = layer.get(i);
                String r = (i + 1 < layer.size()) ? layer.get(i + 1) : l;
                next.add(hash(l + r));
            }
            layer = next;
        }
        return layer.get(0);
    }

    private String hash(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(md.digest(s.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getRoot() {
        return root;
    }
}
