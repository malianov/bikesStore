package net.igorok.domain.valueobjects;

import net.igorok.domain.entity.FoldingBike;

public enum Vendor {
    FOLDING_BIKE("FOLDING BIKE"),
    SPEEDELEC("SPEEDELEC"),
    E_BIKE("E-BIKE");

    String name;

    Vendor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}