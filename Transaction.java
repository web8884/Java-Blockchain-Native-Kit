public class Transaction {
    public final String txId;
    public final String sender;
    public final String recipient;
    public final double amount;
    public final long timestamp;

    public Transaction(String sender, String recipient, double amount) {
        this.timestamp = System.currentTimeMillis();
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.txId = generateTxId();
    }

    private String generateTxId() {
        return HashUtil.sha256(sender + recipient + amount + timestamp);
    }
}
