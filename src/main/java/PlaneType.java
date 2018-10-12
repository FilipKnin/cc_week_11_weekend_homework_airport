public enum PlaneType {
    BOEING747(5),
    BOEING787(100),
    AIRBUS330(50),
    AIRBUS350(80),
    AIRBUS380(10);

    private final int capacity;

    PlaneType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }


}
