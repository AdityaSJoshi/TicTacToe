public enum Side {
    OVAL("O"),
    CROSS("X"),
    UNASSIGNED("-");

    private String side;

    Side (String side) {
        this.side = side;
    }

    public String getSide () {
        return side;
    }
}
