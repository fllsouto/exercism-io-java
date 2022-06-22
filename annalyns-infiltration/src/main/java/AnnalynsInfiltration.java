class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        boolean caseOne = !knightIsAwake;
        return caseOne;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean caseOne = (knightIsAwake || archerIsAwake || prisonerIsAwake);
        return caseOne;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean caseOne = (prisonerIsAwake && !archerIsAwake);
        return caseOne;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        boolean caseOne = (petDogIsPresent && !archerIsAwake);
        boolean caseTwo = (prisonerIsAwake && !knightIsAwake && !archerIsAwake);

        return (caseOne || caseTwo);
    }
}
