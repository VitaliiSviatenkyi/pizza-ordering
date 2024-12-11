package org.example.model.enums;

public enum PizzaName {
    HAWAII("Hawaii"),
    MARGHERITA("Margherita"),
    PEPPERONI("Pepperoni"),
    VEGGIE("Veggie"),
    BBQ("BBQ");

    private final String name;

    PizzaName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


