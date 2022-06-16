public class Lasagna {

    private static final int EXPECTED_MINUTES_BY_LAYER = 2;
    private static final int EXPECTED_MINUTES_IN_OVEN = 40;

    public int expectedMinutesInOven() {
        return EXPECTED_MINUTES_IN_OVEN;
    }

    public int remainingMinutesInOven(int actualMinutes) {
        return this.expectedMinutesInOven() - actualMinutes;
    }

    public int preparationTimeInMinutes(int amountLayers) {
        return EXPECTED_MINUTES_BY_LAYER * amountLayers;
    }

    public int totalTimeInMinutes(int amountLayers, int actualMinutes) {
        return this.preparationTimeInMinutes(amountLayers) + actualMinutes;
    }
}
