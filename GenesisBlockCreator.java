public class GenesisBlockCreator {
    public static BlockHeader createGenesis() {
        long now = System.currentTimeMillis();
        return new BlockHeader(
            "0",
            0,
            now,
            HashUtil.sha256("genesis"),
            0
        );
    }
}
