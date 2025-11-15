package globals

class PDopants {

    static class PDopant {
        String metaItemName
        int efficiency

        PDopant(String metaItemName, int efficiency) {
            this.metaItemName = metaItemName
            this.efficiency = efficiency
        }
    }

    public static final pdopants = [
        new PDopant("dustHighPurityBoron", 1),
        new PDopant("dustHighPurityGallium", 2),
        new PDopant("dustTinyHighPurityIndium", 1)
    ]
}
