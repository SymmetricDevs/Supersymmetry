package globals

class NDopants {

    static class NDopant {
        String metaItemName
        int efficiency

        NDopant(String metaItemName, int efficiency) {
            this.metaItemName = metaItemName
            this.efficiency = efficiency
        }
    }

    public static final ndopants = [
        new NDopant("dustHighPurityAntimony", 1),
        new NDopant("dustHighPurityPhosphorus", 2),
        new NDopant("dustHighPurityArsenic", 2)
    ]
}

