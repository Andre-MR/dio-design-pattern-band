package dev.andremr.patterns;

public enum BrandSingleton {
    INSTANCE;

    public String brandName() {
        return "Design Pattern Band";
    }

    public String brandInitials() {
        return "DPB";
    }
}
