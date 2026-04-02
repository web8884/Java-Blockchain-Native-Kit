import java.util.*;

public class PeerNode {
    private final String nodeId;
    private final Set<String> connectedPeers = new HashSet<>();
    private final Set<String> receivedBlocks = new HashSet<>();

    public PeerNode(String nodeId) {
        this.nodeId = nodeId;
    }

    public void connect(String peer) {
        connectedPeers.add(peer);
    }

    public void broadcastBlock(String blockHash) {
        receivedBlocks.add(blockHash);
        for (String p : connectedPeers) {
            System.out.printf("Node %s broadcast to %s: %s%n", nodeId, p, blockHash);
        }
    }

    public boolean hasBlock(String hash) {
        return receivedBlocks.contains(hash);
    }
}
