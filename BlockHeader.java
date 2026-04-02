import java.security.MessageDigest;
import java.util.HexFormat;

public class BlockHeader {
    public final String prevHash;
    public final long height;
    public final long timestamp;
    public final String txRoot;
    public final long nonce;
    public final String hash;

    public BlockHeader(String prevHash, long height, long timestamp, String txRoot, long nonce) {
        this.prevHash = prevHash;
        this.height = height;
        this.timestamp = timestamp;
        this.txRoot = txRoot;
        this.nonce = nonce;
        this.hash = computeHash();
    }

    private String computeHash() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String raw = prevHash + height + timestamp + txRoot + nonce;
            byte[] d = md.digest(raw.getBytes());
            return HexFormat.of().formatHex(d);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
